package multi.platform.auth.app.register

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import multi.platform.auth.R
import multi.platform.auth.databinding.RegisterFragmentBinding
import multi.platform.auth.shared.app.register.RegisterViewModel
import multi.platform.auth.shared.external.constant.AuthConstant
import multi.platform.core.shared.app.common.BaseFragment
import multi.platform.core.shared.domain.common.entity.Ticket
import multi.platform.core.shared.external.constant.AppConstant
import multi.platform.core.shared.external.extension.getPathFromURI
import multi.platform.core.shared.external.extension.showErrorSnackbar
import multi.platform.core.shared.external.extension.showKeyboard
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class RegisterFragment : BaseFragment<RegisterFragmentBinding>(
    R.layout.register_fragment
) {
    private val vm: RegisterViewModel by viewModel()

    override fun actionBarTitle() = getString(R.string.register_title)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = vm
        val scope = viewLifecycleOwner.lifecycleScope
        scope.launchWhenResumed { vm.loadingIndicator.collect { showFullLoading(it) } }
        scope.launchWhenResumed { vm.errorMessage.collect { showErrorSnackbar(it) } }
        scope.launchWhenResumed { vm.onSignedIn.collect { onSignedIn(it) } }

        arguments?.let {
            vm.country.value = it.getString("country")
            vm.phone.value = it.getString("phone")
            vm.transactionId = it.getString("transactionId").toString()
        }
        binding.ivAvatar.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startForResultFromGallery.launch(intent)
        }
        binding.addAvatar.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startForResultFromGallery.launch(intent)
        }
        Handler(Looper.getMainLooper()).postDelayed({
            showKeyboard(binding.etName)
        }, 300)
    }

    private fun onSignedIn(ticket: Ticket?) {
        ticket?.let {
            sharedPreferences.edit()
                .putString(AppConstant.ACCESS_TOKEN, it.session?.token)
                .putString(AppConstant.REFRESH_TOKEN, it.session?.refreshToken)
                .apply()
            setFragmentResult(
                AuthConstant.REGISTER_REQ,
                bundleOf(AuthConstant.REGISTER_REQ to true)
            )
            findNavController().navigateUp()
        }
    }

    private val startForResultFromGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                try {
                    if (result.data != null) {
                        val selectedImageUri = result.data?.data
                        selectedImageUri?.let {
                            vm.picturePath.value = getPathFromURI(it)
                            val bitmap = BitmapFactory.decodeStream(
                                requireContext().contentResolver.openInputStream(it)
                            )
                            binding.ivAvatar.setImageBitmap(bitmap)
                        }
                    }
                } catch (exception: Exception) {
                    Timber.d("TAG", "" + exception.localizedMessage)
                }
            }
        }
}