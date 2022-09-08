//[auth](../../../index.md)/[tossaro.android.auth.data.user.network](../index.md)/[UserServiceV1](index.md)/[signInEmail](sign-in-email.md)

# signInEmail

[androidJvm]\

@FormUrlEncoded()

@POST(value = &quot;/api/user/signInEmail&quot;)

public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[signInEmail](sign-in-email.md)(@Field(value = &quot;email&quot;)[String](https://developer.android.com/reference/kotlin/java/lang/String.html)email, @Field(value = &quot;password&quot;)[String](https://developer.android.com/reference/kotlin/java/lang/String.html)password)
