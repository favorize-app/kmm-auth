//[auth](../../../index.md)/[tossaro.android.auth.data.user](../index.md)/[UserRepositoryImpl](index.md)

# UserRepositoryImpl

[androidJvm]\
public final class [UserRepositoryImpl](index.md) implements [UserRepository](../../tossaro.android.auth.domain.user/-user-repository/index.md)

## Constructors

| | |
|---|---|
| [UserRepositoryImpl](-user-repository-impl.md) | [androidJvm]<br>public [UserRepositoryImpl](index.md)[UserRepositoryImpl](-user-repository-impl.md)([UserServiceV1](../../tossaro.android.auth.data.user.network/-user-service-v1/index.md)userServiceV1) |

## Functions

| Name | Summary |
|---|---|
| [checkPhone](check-phone.md) | [androidJvm]<br>public NetworkResponse&lt;ApiResponse&lt;Ticket&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[checkPhone](check-phone.md)([String](https://developer.android.com/reference/kotlin/java/lang/String.html)phone) |
| [register](register.md) | [androidJvm]<br>public NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[register](register.md)([User](../../tossaro.android.auth.domain.user.entity/-user/index.md)user) |
| [signInEmail](sign-in-email.md) | [androidJvm]<br>public NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[signInEmail](sign-in-email.md)([String](https://developer.android.com/reference/kotlin/java/lang/String.html)email, [String](https://developer.android.com/reference/kotlin/java/lang/String.html)password) |
| [signInProvider](sign-in-provider.md) | [androidJvm]<br>public NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[signInProvider](sign-in-provider.md)([String](https://developer.android.com/reference/kotlin/java/lang/String.html)provider, [String](https://developer.android.com/reference/kotlin/java/lang/String.html)token) |
| [verifyOtpRegister](verify-otp-register.md) | [androidJvm]<br>public NetworkResponse&lt;ApiResponse&lt;Ticket&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[verifyOtpRegister](verify-otp-register.md)([Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp) |
| [verifyOtpSignIn](verify-otp-sign-in.md) | [androidJvm]<br>public NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[verifyOtpSignIn](verify-otp-sign-in.md)([Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp) |
