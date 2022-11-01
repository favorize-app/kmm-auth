//[auth](../../../index.md)/[tossaro.android.auth.data.user.network](../index.md)/[UserServiceV1](index.md)/[signInProvider](sign-in-provider.md)

# signInProvider

[androidJvm]\

@FormUrlEncoded()

@POST(value = &quot;/api/user/signInProvider&quot;)

public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[signInProvider](sign-in-provider.md)(@Field(value = &quot;provider&quot;)[String](https://developer.android.com/reference/kotlin/java/lang/String.html)provider, @Field(value = &quot;token&quot;)[String](https://developer.android.com/reference/kotlin/java/lang/String.html)token)
