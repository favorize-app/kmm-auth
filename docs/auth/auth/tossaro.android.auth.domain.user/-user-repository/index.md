//[auth](../../../index.md)/[tossaro.android.auth.domain.user](../index.md)/[UserRepository](index.md)

# UserRepository

[androidJvm]\
public interface [UserRepository](index.md)

## Functions

| Name | Summary |
|---|---|
| [checkPhone](check-phone.md) | [androidJvm]<br>public abstract NetworkResponse&lt;ApiResponse&lt;Ticket&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[checkPhone](check-phone.md)([String](https://developer.android.com/reference/kotlin/java/lang/String.html)phone) |
| [register](register.md) | [androidJvm]<br>public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[register](register.md)([User](../../tossaro.android.auth.domain.user.entity/-user/index.md)user) |
| [signInEmail](sign-in-email.md) | [androidJvm]<br>public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[signInEmail](sign-in-email.md)([String](https://developer.android.com/reference/kotlin/java/lang/String.html)email, [String](https://developer.android.com/reference/kotlin/java/lang/String.html)password) |
| [signInProvider](sign-in-provider.md) | [androidJvm]<br>public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[signInProvider](sign-in-provider.md)([String](https://developer.android.com/reference/kotlin/java/lang/String.html)provider, [String](https://developer.android.com/reference/kotlin/java/lang/String.html)token) |
| [verifyOtpRegister](verify-otp-register.md) | [androidJvm]<br>public abstract NetworkResponse&lt;ApiResponse&lt;Ticket&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[verifyOtpRegister](verify-otp-register.md)([Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp) |
| [verifyOtpSignIn](verify-otp-sign-in.md) | [androidJvm]<br>public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[verifyOtpSignIn](verify-otp-sign-in.md)([Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp) |

## Inheritors

| Name |
|---|
| [UserRepositoryImpl](../../tossaro.android.auth.data.user/-user-repository-impl/index.md) |
