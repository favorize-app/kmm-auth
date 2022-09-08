//[auth](../../../index.md)/[tossaro.android.auth.data.user.network](../index.md)/[UserServiceV1](index.md)/[verifyOtpSignIn](verify-otp-sign-in.md)

# verifyOtpSignIn

[androidJvm]\

@FormUrlEncoded()

@POST(value = &quot;/user/api/v1/verify&quot;)

public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[verifyOtpSignIn](verify-otp-sign-in.md)(@Field(value = &quot;otp&quot;)[Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp)
