//[auth](../../../index.md)/[tossaro.android.auth.app.signin](../index.md)/[SignInViewModel](index.md)

# SignInViewModel

[androidJvm]\
public final class [SignInViewModel](index.md) extends BaseViewModel

## Constructors

| | |
|---|---|
| [SignInViewModel](-sign-in-view-model.md) | [androidJvm]<br>public [SignInViewModel](index.md)[SignInViewModel](-sign-in-view-model.md)([CheckPhoneUseCase](../../tossaro.android.auth.domain.user.usecase/-check-phone-use-case/index.md)checkPhoneUseCase, [SignInEmailUseCase](../../tossaro.android.auth.domain.user.usecase/-sign-in-email-use-case/index.md)signInEmailUseCase, [SignInProviderUseCase](../../tossaro.android.auth.domain.user.usecase/-sign-in-provider-use-case/index.md)signInProviderUseCase) |

## Functions

| Name | Summary |
|---|---|
| [emailValidate](email-validate.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[emailValidate](email-validate.md)() |
| [getCountry](get-country.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getCountry](get-country.md)() |
| [getEmail](get-email.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getEmail](get-email.md)() |
| [getEmailError](get-email-error.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Integer](https://developer.android.com/reference/kotlin/java/lang/Integer.html)&gt;[getEmailError](get-email-error.md)() |
| [getOnCheckPhone](get-on-check-phone.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;Ticket&gt;[getOnCheckPhone](get-on-check-phone.md)() |
| [getPassword](get-password.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getPassword](get-password.md)() |
| [getPasswordError](get-password-error.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Integer](https://developer.android.com/reference/kotlin/java/lang/Integer.html)&gt;[getPasswordError](get-password-error.md)() |
| [getPhone](get-phone.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getPhone](get-phone.md)() |
| [getPhoneError](get-phone-error.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Integer](https://developer.android.com/reference/kotlin/java/lang/Integer.html)&gt;[getPhoneError](get-phone-error.md)() |
| [getSignInByFacebookTrigger](get-sign-in-by-facebook-trigger.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Boolean](https://developer.android.com/reference/kotlin/java/lang/Boolean.html)&gt;[getSignInByFacebookTrigger](get-sign-in-by-facebook-trigger.md)() |
| [getSignInByGoogleTrigger](get-sign-in-by-google-trigger.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Boolean](https://developer.android.com/reference/kotlin/java/lang/Boolean.html)&gt;[getSignInByGoogleTrigger](get-sign-in-by-google-trigger.md)() |
| [getSignInType](get-sign-in-type.md) | [androidJvm]<br>public final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[getSignInType](get-sign-in-type.md)() |
| [goToForgotPassword](go-to-forgot-password.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[goToForgotPassword](go-to-forgot-password.md)() |
| [goToRegister](go-to-register.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[goToRegister](go-to-register.md)() |
| [onGetAccessToken](on-get-access-token.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[onGetAccessToken](on-get-access-token.md)([String](https://developer.android.com/reference/kotlin/java/lang/String.html)provider, [String](https://developer.android.com/reference/kotlin/java/lang/String.html)accessToken) |
| [onGetAccessTokenFail](on-get-access-token-fail.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[onGetAccessTokenFail](on-get-access-token-fail.md)([String](https://developer.android.com/reference/kotlin/java/lang/String.html)error) |
| [passwordValidate](password-validate.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[passwordValidate](password-validate.md)() |
| [phoneValidate](phone-validate.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[phoneValidate](phone-validate.md)([String](https://developer.android.com/reference/kotlin/java/lang/String.html)defaultCountryCode) |
| [saveTokenLocal](save-token-local.md) | [androidJvm]<br>public final Job[saveTokenLocal](save-token-local.md)(ApiResponse&lt;Token&gt;apiResponse) |
| [signInByFacebook](sign-in-by-facebook.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[signInByFacebook](sign-in-by-facebook.md)() |
| [signInByGoogle](sign-in-by-google.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[signInByGoogle](sign-in-by-google.md)([Context](https://developer.android.com/reference/kotlin/android/content/Context.html)context) |
| [signInEmail](sign-in-email.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[signInEmail](sign-in-email.md)() |
| [signInFingerprint](sign-in-fingerprint.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[signInFingerprint](sign-in-fingerprint.md)([Context](https://developer.android.com/reference/kotlin/android/content/Context.html)context) |
| [signInPhone](sign-in-phone.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[signInPhone](sign-in-phone.md)() |
| [toggleEmailForm](toggle-email-form.md) | [androidJvm]<br>public final [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)[toggleEmailForm](toggle-email-form.md)() |

## Properties

| Name | Summary |
|---|---|
| [country](index.md#599436568%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[country](index.md#599436568%2FProperties%2F1695297054) |
| [email](index.md#2061075474%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[email](index.md#2061075474%2FProperties%2F1695297054) |
| [emailError](index.md#237912992%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Integer](https://developer.android.com/reference/kotlin/java/lang/Integer.html)&gt;[emailError](index.md#237912992%2FProperties%2F1695297054) |
| [onCheckPhone](index.md#-2068655801%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;Ticket&gt;[onCheckPhone](index.md#-2068655801%2FProperties%2F1695297054) |
| [password](index.md#2019440497%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[password](index.md#2019440497%2FProperties%2F1695297054) |
| [passwordError](index.md#-121777247%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Integer](https://developer.android.com/reference/kotlin/java/lang/Integer.html)&gt;[passwordError](index.md#-121777247%2FProperties%2F1695297054) |
| [phone](index.md#-255335808%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[phone](index.md#-255335808%2FProperties%2F1695297054) |
| [phoneError](index.md#1077918194%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Integer](https://developer.android.com/reference/kotlin/java/lang/Integer.html)&gt;[phoneError](index.md#1077918194%2FProperties%2F1695297054) |
| [signInByFacebookTrigger](index.md#-1282309899%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Boolean](https://developer.android.com/reference/kotlin/java/lang/Boolean.html)&gt;[signInByFacebookTrigger](index.md#-1282309899%2FProperties%2F1695297054) |
| [signInByGoogleTrigger](index.md#1604612840%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[Boolean](https://developer.android.com/reference/kotlin/java/lang/Boolean.html)&gt;[signInByGoogleTrigger](index.md#1604612840%2FProperties%2F1695297054) |
| [signInType](index.md#1962915664%2FProperties%2F1695297054) | [androidJvm]<br>private final [MutableLiveData](https://developer.android.com/reference/kotlin/androidx/lifecycle/MutableLiveData.html)&lt;[String](https://developer.android.com/reference/kotlin/java/lang/String.html)&gt;[signInType](index.md#1962915664%2FProperties%2F1695297054) |
