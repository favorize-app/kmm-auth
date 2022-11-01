//[auth](../../../index.md)/[tossaro.android.auth.data.user.network](../index.md)/[UserServiceV1](index.md)/[register](register.md)

# register

[androidJvm]\

@FormUrlEncoded()

@POST(value = &quot;/api/user/register&quot;)

public abstract NetworkResponse&lt;ApiResponse&lt;Token&gt;, ApiResponse&lt;[Void](https://developer.android.com/reference/kotlin/java/lang/Void.html)&gt;&gt;[register](register.md)(@Field(value = &quot;user&quot;)[User](../../tossaro.android.auth.domain.user.entity/-user/index.md)user)
