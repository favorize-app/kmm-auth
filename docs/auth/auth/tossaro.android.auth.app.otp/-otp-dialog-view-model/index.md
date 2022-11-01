//[auth](../../../index.md)/[tossaro.android.auth.app.otp](../index.md)/[OtpDialogViewModel](index.md)

# OtpDialogViewModel

[androidJvm]\
public final class [OtpDialogViewModel](index.md) extends BaseViewModel

## Constructors

| | |
|---|---|
| [OtpDialogViewModel](-otp-dialog-view-model.md) | [androidJvm]<br>public [OtpDialogViewModel](index.md)[OtpDialogViewModel](-otp-dialog-view-model.md)([CheckPhoneUseCase](../../tossaro.android.auth.domain.user.usecase/-check-phone-use-case/index.md)checkPhoneUseCase, [VerifyOtpSignInUseCase](../../tossaro.android.auth.domain.user.usecase/-verify-otp-sign-in-use-case/index.md)verifyOtpSignInUseCase, [VerifyOtpRegisterUseCase](../../tossaro.android.auth.domain.user.usecase/-verify-otp-register-use-case/index.md)verifyOtpRegisterUseCase) |

## Functions

| Name | Summary |
|---|---|
| [getCountry](get-country.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getCountry](get-country.md)() |
| [getOnOTPVerifyRegister](get-on-o-t-p-verify-register.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;Ticket&gt;[getOnOTPVerifyRegister](get-on-o-t-p-verify-register.md)() |
| [getOnResendOtp](get-on-resend-otp.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;Ticket&gt;[getOnResendOtp](get-on-resend-otp.md)() |
| [getOtp1](get-otp1.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getOtp1](get-otp1.md)() |
| [getOtp2](get-otp2.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getOtp2](get-otp2.md)() |
| [getOtp3](get-otp3.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getOtp3](get-otp3.md)() |
| [getOtp4](get-otp4.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getOtp4](get-otp4.md)() |
| [getOtp5](get-otp5.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getOtp5](get-otp5.md)() |
| [getOtp6](get-otp6.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getOtp6](get-otp6.md)() |
| [getOtpInfo](get-otp-info.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getOtpInfo](get-otp-info.md)() |
| [getOtpResend](get-otp-resend.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getOtpResend](get-otp-resend.md)() |
| [getPhone](get-phone.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getPhone](get-phone.md)() |
| [getTicketId](get-ticket-id.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getTicketId](get-ticket-id.md)() |
| [getTime](get-time.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getTime](get-time.md)() |
| [getType](get-type.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getType](get-type.md)() |
| [resendOtp](resend-otp.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[resendOtp](resend-otp.md)() |
| [verifyOtp](verify-otp.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[verifyOtp](verify-otp.md)([Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp) |
| [verifyOtpRegister](verify-otp-register.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[verifyOtpRegister](verify-otp-register.md)([Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp) |
| [verifyOtpSignIn](verify-otp-sign-in.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[verifyOtpSignIn](verify-otp-sign-in.md)([Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp) |

## Properties

| Name | Summary |
|---|---|
| [country](index.md#-1249751944%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[country](index.md#-1249751944%2FProperties%2F1695297054) |
| [onOTPVerifyRegister](index.md#-414806874%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;Ticket&gt;[onOTPVerifyRegister](index.md#-414806874%2FProperties%2F1695297054) |
| [onResendOtp](index.md#-92102115%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;Ticket&gt;[onResendOtp](index.md#-92102115%2FProperties%2F1695297054) |
| [otp1](index.md#1775563302%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[otp1](index.md#1775563302%2FProperties%2F1695297054) |
| [otp2](index.md#1806583109%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[otp2](index.md#1806583109%2FProperties%2F1695297054) |
| [otp3](index.md#1837602916%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[otp3](index.md#1837602916%2FProperties%2F1695297054) |
| [otp4](index.md#1868622723%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[otp4](index.md#1868622723%2FProperties%2F1695297054) |
| [otp5](index.md#1899642530%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[otp5](index.md#1899642530%2FProperties%2F1695297054) |
| [otp6](index.md#1930662337%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[otp6](index.md#1930662337%2FProperties%2F1695297054) |
| [otpInfo](index.md#490053365%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[otpInfo](index.md#490053365%2FProperties%2F1695297054) |
| [otpResend](index.md#2120134280%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[otpResend](index.md#2120134280%2FProperties%2F1695297054) |
| [phone](index.md#-592455200%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[phone](index.md#-592455200%2FProperties%2F1695297054) |
| [ticketId](index.md#-1561004315%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[ticketId](index.md#-1561004315%2FProperties%2F1695297054) |
| [time](index.md#-1818572897%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[time](index.md#-1818572897%2FProperties%2F1695297054) |
| [type](index.md#1285451730%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[type](index.md#1285451730%2FProperties%2F1695297054) |
