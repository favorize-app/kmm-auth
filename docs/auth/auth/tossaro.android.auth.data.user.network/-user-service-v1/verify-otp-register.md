//[auth](../../../index.md)/[tossaro.android.auth.data.user.network](../index.md)/[UserServiceV1](index.md)/[verifyOtpRegister](verify-otp-register.md)

# verifyOtpRegister

[androidJvm]\

@FormUrlEncoded()

@POST(value = &quot;/user/api/v1/verify&quot;)

public abstract NetworkResponse&lt;ApiResponse&lt;Ticket&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[verifyOtpRegister](verify-otp-register.md)(@Field(value = &quot;otp&quot;)[Number](https://developer.android.com/reference/kotlin/java/lang/Number.html)otp)
