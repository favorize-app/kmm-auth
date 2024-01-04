Pod::Spec.new do |spec|
    spec.name                  = 'auth_shared'
    spec.version               = '0.7.0'
    spec.homepage              = 'https://gitlab.com/kotlin-multiplatform-mobile/auth'
    spec.source                = { :git => 'https://gitlab.com/kotlin-multiplatform-mobile/auth.git', :tag => spec.version.to_s }
    spec.license               = { :type => 'MIT', :file => 'LICENSE' }
    spec.summary               = 'Provide Sign In with multiple provider'
    spec.authors      		   =  { 'tossaro' => 'hamzah.tossaro@gmail.com' }
    spec.vendored_frameworks   = 'auth_shared/build/XCFrameworks/release/auth_shared.xcframework'
    spec.libraries             = 'c++'
    spec.ios.deployment_target = '14.1'
end