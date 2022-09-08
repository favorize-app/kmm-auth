//[auth](../../../index.md)/[tossaro.android.auth.data.user.network](../index.md)/[UserServiceV1](index.md)

# UserServiceV1

[androidJvm]\
public interface [UserServiceV1](index.md)

## Functions

| Name | Summary |
|---|---|
| [checkPhone](check-phone.md) | [androidJvm]<br>@FormUrlEncoded()<br>@POST(value = &quot;/user/api/sign-in&quot;)<br>public abstract NetworkResponse&lt;ApiResponse&lt;Ticket&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[checkPhone](check-phone.md)(@Field(value = &quot;phone&quot;)[String](https://developer.android.com/reference/kotlin/java/lang/String.html)phone) |
| [register](register.md) | [androidJvm]<br>@FormUrlEncoded()<br>@POST(value = &quot;/api/user/register&quot;)<br>public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[register](register.md)(@Field(value = &quot;user&quot;)[User](../../tossaro.android.auth.domain.user.entity/-user/index.md)user) |
| [signInEmail](sign-in-email.md) | [androidJvm]<br>@FormUrlEncoded()<br>@POST(value = &quot;/api/user/signInEmail&quot;)<br>public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[signInEmail](sign-in-email.md)(@Field(value = &quot;email&quot;)[String](https://developer.android.com/reference/kotlin/java/lang/String.html)email, @Field(value = &quot;password&quot;)[String](https://developer.android.com/reference/kotlin/java/lang/String.html)password) |
| [signInProvider](sign-in-provider.md) | [androidJvm]<br>@FormUrlEncoded()<br>@POST(value = &quot;/api/user/signInProvider&quot;)<br>public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[signInProvider](sign-in-provider.md)(@Field(value = &quot;provider&quot;)[String](https://developer.android.com/reference/kotlin/java/lang/String.html)provider, @Field(value = &quot;token&quot;)[String](https://developer.android.com/reference/kotlin/java/lang/String.html)token) |
| [verifyOtpRegister](verify-otp-register.md) | [androidJvm]<br>@FormUrlEncoded()<br>@POST(value = &quot;/user/api/v1/verify&quot;)<br>public abstract NetworkResponse&lt;ApiResponse&lt;Ticket&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[verifyOtpRegister](verify-otp-register.md)(@Field(value = &quot;otp&quot;)[Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp) |
| [verifyOtpSignIn](verify-otp-sign-in.md) | [androidJvm]<br>@FormUrlEncoded()<br>@POST(value = &quot;/user/api/v1/verify&quot;)<br>public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[verifyOtpSignIn](verify-otp-sign-in.md)(@Field(value = &quot;otp&quot;)[Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp) |
