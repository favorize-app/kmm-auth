#import <Foundation/NSArray.h>
#import <Foundation/NSDictionary.h>
#import <Foundation/NSError.h>
#import <Foundation/NSObject.h>
#import <Foundation/NSSet.h>
#import <Foundation/NSString.h>
#import <Foundation/NSValue.h>

@class Auth_sharedKoin_coreModule, Auth_sharedTicket, Auth_sharedKotlinx_serialization_jsonJsonElement, Auth_sharedAuthKey, Auth_sharedKotlinEnumCompanion, Auth_sharedKotlinEnum<E>, Auth_sharedAuthType, Auth_sharedKotlinArray<T>, Auth_sharedUserState, Auth_sharedCore_sharedCoreViewModel, Auth_sharedRegisterUseCase, Auth_sharedKotlinByteArray, Auth_sharedSignOutUseCase, Auth_sharedAuthorizationUseCase, Auth_sharedValidatePhoneUseCase, Auth_sharedSignInEmailUseCase, Auth_sharedSignInProviderUseCase, Auth_sharedUserReq, Auth_sharedForgetPasswordUseCase, Auth_sharedVerifyOtpUseCase, Auth_sharedEmailReqCompanion, Auth_sharedEmailReq, Auth_sharedSignInByEmailReqCompanion, Auth_sharedSignInByEmailReq, Auth_sharedSignInByPhoneReqCompanion, Auth_sharedSignInByPhoneReq, Auth_sharedSigninProviderReqCompanion, Auth_sharedSigninProviderReq, Auth_sharedVerifyOtpReqCompanion, Auth_sharedVerifyOtpReq, Auth_sharedCountryCode, Auth_sharedOtpCompanion, Auth_sharedOtp, Auth_sharedSessionCompanion, Auth_sharedSession, Auth_sharedTicketCompanion, Auth_sharedKoin_coreKoinDefinition<R>, Auth_sharedKoin_coreScope, Auth_sharedKoin_coreParametersHolder, Auth_sharedKoin_coreInstanceFactory<T>, Auth_sharedKoin_coreSingleInstanceFactory<T>, Auth_sharedKoin_coreScopeDSL, Auth_sharedKotlinx_serialization_jsonJsonElementCompanion, Auth_sharedKotlinByteIterator, Auth_sharedKotlinThrowable, Auth_sharedKotlinException, Auth_sharedKotlinRuntimeException, Auth_sharedKotlinIllegalStateException, NSObject, Auth_sharedKotlinx_serialization_jsonJson, Auth_sharedKtor_httpURLProtocol, Auth_sharedKoin_coreLockable, Auth_sharedKoin_coreKoin, Auth_sharedKotlinLazyThreadSafetyMode, Auth_sharedKoin_coreLogger, Auth_sharedKoin_coreBeanDefinition<T>, Auth_sharedKoin_coreInstanceFactoryCompanion, Auth_sharedKoin_coreInstanceContext, Auth_sharedKotlinx_serialization_coreSerializersModule, Auth_sharedKotlinx_serialization_jsonJsonDefault, Auth_sharedKotlinx_serialization_jsonJsonConfiguration, Auth_sharedKtor_httpURLProtocolCompanion, Auth_sharedKotlinx_serialization_coreSerialKind, Auth_sharedKotlinNothing, Auth_sharedKoin_coreExtensionManager, Auth_sharedKoin_coreInstanceRegistry, Auth_sharedKoin_corePropertyRegistry, Auth_sharedKoin_coreScopeRegistry, Auth_sharedKoin_coreLevel, Auth_sharedKoin_coreKind, Auth_sharedKoin_coreCallbacks<T>, Auth_sharedKoin_coreScopeRegistryCompanion;

@protocol Auth_sharedAuthConfig, Auth_sharedKotlinComparable, Auth_sharedKotlinx_coroutines_coreMutableStateFlow, Auth_sharedKotlinx_coroutines_coreCoroutineScope, Auth_sharedAuthRepository, Auth_sharedCore_sharedApiClientProvider, Auth_sharedKotlinx_serialization_coreKSerializer, Auth_sharedKoin_coreQualifier, Auth_sharedKotlinIterator, Auth_sharedKotlinx_coroutines_coreFlowCollector, Auth_sharedKotlinx_coroutines_coreFlow, Auth_sharedKotlinx_coroutines_coreSharedFlow, Auth_sharedKotlinx_coroutines_coreStateFlow, Auth_sharedKotlinx_coroutines_coreMutableSharedFlow, Auth_sharedKotlinCoroutineContext, Auth_sharedCore_sharedCoreConfig, Auth_sharedCore_sharedRefreshTokenUseCase, Auth_sharedKotlinx_serialization_coreEncoder, Auth_sharedKotlinx_serialization_coreSerialDescriptor, Auth_sharedKotlinx_serialization_coreSerializationStrategy, Auth_sharedKotlinx_serialization_coreDecoder, Auth_sharedKotlinx_serialization_coreDeserializationStrategy, Auth_sharedKotlinKClass, Auth_sharedKotlinLazy, Auth_sharedKoin_coreScopeCallback, Auth_sharedKotlinCoroutineContextElement, Auth_sharedKotlinCoroutineContextKey, Auth_sharedKotlinx_serialization_coreSerialFormat, Auth_sharedKotlinx_serialization_coreStringFormat, Auth_sharedCore_sharedCoreUseCase, Auth_sharedKotlinx_serialization_coreCompositeEncoder, Auth_sharedKotlinAnnotation, Auth_sharedKotlinx_serialization_coreCompositeDecoder, Auth_sharedKoin_coreKoinScopeComponent, Auth_sharedKotlinKDeclarationContainer, Auth_sharedKotlinKAnnotatedElement, Auth_sharedKotlinKClassifier, Auth_sharedKotlinx_serialization_coreSerializersModuleCollector, Auth_sharedKotlinx_serialization_jsonJsonNamingStrategy, Auth_sharedKoin_coreKoinComponent, Auth_sharedKoin_coreKoinExtension;

NS_ASSUME_NONNULL_BEGIN
#pragma clang diagnostic push
#pragma clang diagnostic ignored "-Wunknown-warning-option"
#pragma clang diagnostic ignored "-Wincompatible-property-type"
#pragma clang diagnostic ignored "-Wnullability"

#pragma push_macro("_Nullable_result")
#if !__has_feature(nullability_nullable_result)
#undef _Nullable_result
#define _Nullable_result _Nullable
#endif

__attribute__((swift_name("KotlinBase")))
@interface Auth_sharedBase : NSObject
- (instancetype)init __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
+ (void)initialize __attribute__((objc_requires_super));
@end

@interface Auth_sharedBase (Auth_sharedBaseCopying) <NSCopying>
@end

__attribute__((swift_name("KotlinMutableSet")))
@interface Auth_sharedMutableSet<ObjectType> : NSMutableSet<ObjectType>
@end

__attribute__((swift_name("KotlinMutableDictionary")))
@interface Auth_sharedMutableDictionary<KeyType, ObjectType> : NSMutableDictionary<KeyType, ObjectType>
@end

@interface NSError (NSErrorAuth_sharedKotlinException)
@property (readonly) id _Nullable kotlinException;
@end

__attribute__((swift_name("KotlinNumber")))
@interface Auth_sharedNumber : NSNumber
- (instancetype)initWithChar:(char)value __attribute__((unavailable));
- (instancetype)initWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
- (instancetype)initWithShort:(short)value __attribute__((unavailable));
- (instancetype)initWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
- (instancetype)initWithInt:(int)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
- (instancetype)initWithLong:(long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
- (instancetype)initWithLongLong:(long long)value __attribute__((unavailable));
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
- (instancetype)initWithFloat:(float)value __attribute__((unavailable));
- (instancetype)initWithDouble:(double)value __attribute__((unavailable));
- (instancetype)initWithBool:(BOOL)value __attribute__((unavailable));
- (instancetype)initWithInteger:(NSInteger)value __attribute__((unavailable));
- (instancetype)initWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
+ (instancetype)numberWithChar:(char)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedChar:(unsigned char)value __attribute__((unavailable));
+ (instancetype)numberWithShort:(short)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedShort:(unsigned short)value __attribute__((unavailable));
+ (instancetype)numberWithInt:(int)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInt:(unsigned int)value __attribute__((unavailable));
+ (instancetype)numberWithLong:(long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLong:(unsigned long)value __attribute__((unavailable));
+ (instancetype)numberWithLongLong:(long long)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value __attribute__((unavailable));
+ (instancetype)numberWithFloat:(float)value __attribute__((unavailable));
+ (instancetype)numberWithDouble:(double)value __attribute__((unavailable));
+ (instancetype)numberWithBool:(BOOL)value __attribute__((unavailable));
+ (instancetype)numberWithInteger:(NSInteger)value __attribute__((unavailable));
+ (instancetype)numberWithUnsignedInteger:(NSUInteger)value __attribute__((unavailable));
@end

__attribute__((swift_name("KotlinByte")))
@interface Auth_sharedByte : Auth_sharedNumber
- (instancetype)initWithChar:(char)value;
+ (instancetype)numberWithChar:(char)value;
@end

__attribute__((swift_name("KotlinUByte")))
@interface Auth_sharedUByte : Auth_sharedNumber
- (instancetype)initWithUnsignedChar:(unsigned char)value;
+ (instancetype)numberWithUnsignedChar:(unsigned char)value;
@end

__attribute__((swift_name("KotlinShort")))
@interface Auth_sharedShort : Auth_sharedNumber
- (instancetype)initWithShort:(short)value;
+ (instancetype)numberWithShort:(short)value;
@end

__attribute__((swift_name("KotlinUShort")))
@interface Auth_sharedUShort : Auth_sharedNumber
- (instancetype)initWithUnsignedShort:(unsigned short)value;
+ (instancetype)numberWithUnsignedShort:(unsigned short)value;
@end

__attribute__((swift_name("KotlinInt")))
@interface Auth_sharedInt : Auth_sharedNumber
- (instancetype)initWithInt:(int)value;
+ (instancetype)numberWithInt:(int)value;
@end

__attribute__((swift_name("KotlinUInt")))
@interface Auth_sharedUInt : Auth_sharedNumber
- (instancetype)initWithUnsignedInt:(unsigned int)value;
+ (instancetype)numberWithUnsignedInt:(unsigned int)value;
@end

__attribute__((swift_name("KotlinLong")))
@interface Auth_sharedLong : Auth_sharedNumber
- (instancetype)initWithLongLong:(long long)value;
+ (instancetype)numberWithLongLong:(long long)value;
@end

__attribute__((swift_name("KotlinULong")))
@interface Auth_sharedULong : Auth_sharedNumber
- (instancetype)initWithUnsignedLongLong:(unsigned long long)value;
+ (instancetype)numberWithUnsignedLongLong:(unsigned long long)value;
@end

__attribute__((swift_name("KotlinFloat")))
@interface Auth_sharedFloat : Auth_sharedNumber
- (instancetype)initWithFloat:(float)value;
+ (instancetype)numberWithFloat:(float)value;
@end

__attribute__((swift_name("KotlinDouble")))
@interface Auth_sharedDouble : Auth_sharedNumber
- (instancetype)initWithDouble:(double)value;
+ (instancetype)numberWithDouble:(double)value;
@end

__attribute__((swift_name("KotlinBoolean")))
@interface Auth_sharedBoolean : Auth_sharedNumber
- (instancetype)initWithBool:(BOOL)value;
+ (instancetype)numberWithBool:(BOOL)value;
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthModule")))
@interface Auth_sharedAuthModule : Auth_sharedBase
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig __attribute__((swift_name("init(authConfig:)"))) __attribute__((objc_designated_initializer));
- (Auth_sharedKoin_coreModule *)invoke __attribute__((swift_name("invoke()")));
@end

__attribute__((swift_name("AuthConfig")))
@protocol Auth_sharedAuthConfig
@required
- (Auth_sharedTicket * _Nullable)forgetPasswordMapperJsonObject:(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable)jsonObject __attribute__((swift_name("forgetPasswordMapper(jsonObject:)")));
- (Auth_sharedTicket * _Nullable)registerMapperJsonObject:(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable)jsonObject __attribute__((swift_name("registerMapper(jsonObject:)")));
- (Auth_sharedTicket * _Nullable)signInMapperJsonObject:(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable)jsonObject __attribute__((swift_name("signInMapper(jsonObject:)")));
- (Auth_sharedTicket * _Nullable)signOutMapperJsonObject:(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable)jsonObject __attribute__((swift_name("signOutMapper(jsonObject:)")));
- (Auth_sharedTicket * _Nullable)validatePhoneMapperJsonObject:(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable)jsonObject __attribute__((swift_name("validatePhoneMapper(jsonObject:)")));
- (Auth_sharedTicket * _Nullable)verifyOtpMapperJsonObject:(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable)jsonObject __attribute__((swift_name("verifyOtpMapper(jsonObject:)")));
@property (readonly) int32_t countryFlag __attribute__((swift_name("countryFlag")));
@property (readonly) NSString *forgetPasswordApi __attribute__((swift_name("forgetPasswordApi")));
@property (readonly) NSString *headerTransactionIdKey __attribute__((swift_name("headerTransactionIdKey")));
@property (readonly) NSString *host __attribute__((swift_name("host")));
@property (readonly) int32_t logo __attribute__((swift_name("logo")));
@property (readonly) NSString *registerApi __attribute__((swift_name("registerApi")));
@property (readonly) int32_t rootView __attribute__((swift_name("rootView")));
@property (readonly) NSString *signInByEmailApi __attribute__((swift_name("signInByEmailApi")));
@property (readonly) NSString *signInByPhoneApi __attribute__((swift_name("signInByPhoneApi")));
@property (readonly) NSString *signInByProviderApi __attribute__((swift_name("signInByProviderApi")));
@property (readonly) NSString *signOutApi __attribute__((swift_name("signOutApi")));
@property (readonly) NSString *validatePhoneApi __attribute__((swift_name("validatePhoneApi")));
@property (readonly) NSString *verifyOtpApi __attribute__((swift_name("verifyOtpApi")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthKey")))
@interface Auth_sharedAuthKey : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)authKey __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedAuthKey *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *COUNTRY_KEY __attribute__((swift_name("COUNTRY_KEY")));
@property (readonly) NSString *FORGET_PASSWORD_KEY __attribute__((swift_name("FORGET_PASSWORD_KEY")));
@property (readonly) NSString *OTP_KEY __attribute__((swift_name("OTP_KEY")));
@property (readonly) NSString *REGISTER_KEY __attribute__((swift_name("REGISTER_KEY")));
@property (readonly) NSString *SIGN_IN_KEY __attribute__((swift_name("SIGN_IN_KEY")));
@property (readonly) NSString *SIGN_OUT_KEY __attribute__((swift_name("SIGN_OUT_KEY")));
@property (readonly) NSString *TRANSACTION_ID __attribute__((swift_name("TRANSACTION_ID")));
@property (readonly) NSString *VERIFY_KEY __attribute__((swift_name("VERIFY_KEY")));
@end

__attribute__((swift_name("KotlinComparable")))
@protocol Auth_sharedKotlinComparable
@required
- (int32_t)compareToOther:(id _Nullable)other __attribute__((swift_name("compareTo(other:)")));
@end

__attribute__((swift_name("KotlinEnum")))
@interface Auth_sharedKotlinEnum<E> : Auth_sharedBase <Auth_sharedKotlinComparable>
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedKotlinEnumCompanion *companion __attribute__((swift_name("companion")));
- (int32_t)compareToOther:(E)other __attribute__((swift_name("compareTo(other:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@property (readonly) int32_t ordinal __attribute__((swift_name("ordinal")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthType")))
@interface Auth_sharedAuthType : Auth_sharedKotlinEnum<Auth_sharedAuthType *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) Auth_sharedAuthType *phone __attribute__((swift_name("phone")));
@property (class, readonly) Auth_sharedAuthType *email __attribute__((swift_name("email")));
@property (class, readonly) Auth_sharedAuthType *google __attribute__((swift_name("google")));
@property (class, readonly) Auth_sharedAuthType *facebook __attribute__((swift_name("facebook")));
@property (class, readonly) Auth_sharedAuthType *biometric __attribute__((swift_name("biometric")));
@property (class, readonly) Auth_sharedAuthType *undefined __attribute__((swift_name("undefined")));
+ (Auth_sharedKotlinArray<Auth_sharedAuthType *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<Auth_sharedAuthType *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UserState")))
@interface Auth_sharedUserState : Auth_sharedKotlinEnum<Auth_sharedUserState *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) Auth_sharedUserState *validated __attribute__((swift_name("validated")));
@property (class, readonly) Auth_sharedUserState *secured __attribute__((swift_name("secured")));
@property (class, readonly) Auth_sharedUserState *registered __attribute__((swift_name("registered")));
@property (class, readonly) Auth_sharedUserState *activated __attribute__((swift_name("activated")));
@property (class, readonly) Auth_sharedUserState *undefined __attribute__((swift_name("undefined")));
+ (Auth_sharedKotlinArray<Auth_sharedUserState *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<Auth_sharedUserState *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((swift_name("Core_sharedCoreViewModel")))
@interface Auth_sharedCore_sharedCoreViewModel : Auth_sharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (BOOL)validateBlankField:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)field error:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)error __attribute__((swift_name("validateBlank(field:error:)")));
- (BOOL)validateConfirmField1:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)field1 field2:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)field2 error:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)error __attribute__((swift_name("validateConfirm(field1:field2:error:)")));
- (BOOL)validateEmailFormatField:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)field error:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)error __attribute__((swift_name("validateEmailFormat(field:error:)")));
- (BOOL)validateMinCharMin:(int32_t)min field:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)field error:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)error __attribute__((swift_name("validateMinChar(min:field:error:)")));
- (BOOL)validatePasswordFormatField:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)field error:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)error __attribute__((swift_name("validatePasswordFormat(field:error:)")));
- (BOOL)validatePhoneFormatField:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)field error:(id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow>)error __attribute__((swift_name("validatePhoneFormat(field:error:)")));
@property NSString * _Nullable accessToken __attribute__((swift_name("accessToken")));
@property NSString * _Nullable errorConfirm __attribute__((swift_name("errorConfirm")));
@property NSString * _Nullable errorEmailFormat __attribute__((swift_name("errorEmailFormat")));
@property NSString * _Nullable errorEmptyField __attribute__((swift_name("errorEmptyField")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> errorMessage __attribute__((swift_name("errorMessage")));
@property NSString * _Nullable errorMinChar __attribute__((swift_name("errorMinChar")));
@property NSString * _Nullable errorPasswordFormat __attribute__((swift_name("errorPasswordFormat")));
@property NSString * _Nullable errorPhoneFormat __attribute__((swift_name("errorPhoneFormat")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> forceSignout __attribute__((swift_name("forceSignout")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> isEmpty __attribute__((swift_name("isEmpty")));
@property BOOL isFromNetwork __attribute__((swift_name("isFromNetwork")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> loadingIndicator __attribute__((swift_name("loadingIndicator")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onException __attribute__((swift_name("onException")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreCoroutineScope> scope __attribute__((swift_name("scope")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> successMessage __attribute__((swift_name("successMessage")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> toastMessage __attribute__((swift_name("toastMessage")));
@property BOOL useAsyncNetworkCall __attribute__((swift_name("useAsyncNetworkCall")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RegisterViewModel")))
@interface Auth_sharedRegisterViewModel : Auth_sharedCore_sharedCoreViewModel
- (instancetype)initWithRegisterUseCase:(Auth_sharedRegisterUseCase *)registerUseCase __attribute__((swift_name("init(registerUseCase:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)registerImageBytes:(Auth_sharedKotlinByteArray * _Nullable)imageBytes imageName:(NSString * _Nullable)imageName __attribute__((swift_name("register(imageBytes:imageName:)")));
- (Auth_sharedBoolean * _Nullable)validatePassword __attribute__((swift_name("validatePassword()")));
- (Auth_sharedBoolean * _Nullable)validatePasswordConfirm __attribute__((swift_name("validatePasswordConfirm()")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> bio __attribute__((swift_name("bio")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> bioError __attribute__((swift_name("bioError")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> country __attribute__((swift_name("country")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> email __attribute__((swift_name("email")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> emailError __attribute__((swift_name("emailError")));
@property NSString * _Nullable errorPasswordConfirm __attribute__((swift_name("errorPasswordConfirm")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> name __attribute__((swift_name("name")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> nameError __attribute__((swift_name("nameError")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onSignedIn __attribute__((swift_name("onSignedIn")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> password __attribute__((swift_name("password")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> passwordConfirm __attribute__((swift_name("passwordConfirm")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> passwordConfirmError __attribute__((swift_name("passwordConfirmError")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> passwordError __attribute__((swift_name("passwordError")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> phone __attribute__((swift_name("phone")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> phoneError __attribute__((swift_name("phoneError")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> picturePath __attribute__((swift_name("picturePath")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> requirePassword __attribute__((swift_name("requirePassword")));
@property NSString *transactionId __attribute__((swift_name("transactionId")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignOutViewModel")))
@interface Auth_sharedSignOutViewModel : Auth_sharedCore_sharedCoreViewModel
- (instancetype)initWithSignOutUseCase:(Auth_sharedSignOutUseCase *)signOutUseCase __attribute__((swift_name("init(signOutUseCase:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)cancel __attribute__((swift_name("cancel()")));
- (void)signOut __attribute__((swift_name("signOut()")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onCancel __attribute__((swift_name("onCancel")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onSignOut __attribute__((swift_name("onSignOut")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignInViewModel")))
@interface Auth_sharedSignInViewModel : Auth_sharedCore_sharedCoreViewModel
- (instancetype)initWithAuthorizationUseCase:(Auth_sharedAuthorizationUseCase *)authorizationUseCase validatePhoneUseCase:(Auth_sharedValidatePhoneUseCase *)validatePhoneUseCase signInEmailUseCase:(Auth_sharedSignInEmailUseCase *)signInEmailUseCase signInProviderUseCase:(Auth_sharedSignInProviderUseCase *)signInProviderUseCase __attribute__((swift_name("init(authorizationUseCase:validatePhoneUseCase:signInEmailUseCase:signInProviderUseCase:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)goToForgotPassword __attribute__((swift_name("goToForgotPassword()")));
- (void)goToRegister __attribute__((swift_name("goToRegister()")));
- (void)onGetAccessTokenAuthType:(Auth_sharedAuthType *)authType accessToken:(NSString *)accessToken userReq:(Auth_sharedUserReq * _Nullable)userReq __attribute__((swift_name("onGetAccessToken(authType:accessToken:userReq:)")));
- (void)onGetAccessTokenFailError:(NSString * _Nullable)error __attribute__((swift_name("onGetAccessTokenFail(error:)")));
- (void)signInByFacebook __attribute__((swift_name("signInByFacebook()")));
- (void)signInByGoogle __attribute__((swift_name("signInByGoogle()")));
- (void)signInEmail __attribute__((swift_name("signInEmail()")));
- (void)signInPhone __attribute__((swift_name("signInPhone()")));
- (void)sinInByBiometric __attribute__((swift_name("sinInByBiometric()")));
- (void)toggleForm __attribute__((swift_name("toggleForm()")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> authType __attribute__((swift_name("authType")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> country __attribute__((swift_name("country")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> email __attribute__((swift_name("email")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> emailError __attribute__((swift_name("emailError")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onCheckPhone __attribute__((swift_name("onCheckPhone")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onGoToForgetPasswordClick __attribute__((swift_name("onGoToForgetPasswordClick")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onGoToRegisterClick __attribute__((swift_name("onGoToRegisterClick")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onSignInByBiometricClick __attribute__((swift_name("onSignInByBiometricClick")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onSignInByFacebookClick __attribute__((swift_name("onSignInByFacebookClick")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onSignInByGoogleClick __attribute__((swift_name("onSignInByGoogleClick")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onSignedIn __attribute__((swift_name("onSignedIn")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> password __attribute__((swift_name("password")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> passwordError __attribute__((swift_name("passwordError")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> phone __attribute__((swift_name("phone")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> phoneError __attribute__((swift_name("phoneError")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ForgetPasswordViewModel")))
@interface Auth_sharedForgetPasswordViewModel : Auth_sharedCore_sharedCoreViewModel
- (instancetype)initWithForgetPasswordUseCase:(Auth_sharedForgetPasswordUseCase *)forgetPasswordUseCase __attribute__((swift_name("init(forgetPasswordUseCase:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)submit __attribute__((swift_name("submit()")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> email __attribute__((swift_name("email")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> emailError __attribute__((swift_name("emailError")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onSubmit __attribute__((swift_name("onSubmit")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("OtpViewModel")))
@interface Auth_sharedOtpViewModel : Auth_sharedCore_sharedCoreViewModel
- (instancetype)initWithAuthorizationUseCase:(Auth_sharedAuthorizationUseCase *)authorizationUseCase verifyOtpUseCase:(Auth_sharedVerifyOtpUseCase *)verifyOtpUseCase __attribute__((swift_name("init(authorizationUseCase:verifyOtpUseCase:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)resendOtp __attribute__((swift_name("resendOtp()")));
- (void)verifyOtpOtp:(NSString *)otp __attribute__((swift_name("verifyOtp(otp:)")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> country __attribute__((swift_name("country")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onOTPVerifyRegister __attribute__((swift_name("onOTPVerifyRegister")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onResendOtp __attribute__((swift_name("onResendOtp")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> onSignedIn __attribute__((swift_name("onSignedIn")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> otp1 __attribute__((swift_name("otp1")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> otp2 __attribute__((swift_name("otp2")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> otp3 __attribute__((swift_name("otp3")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> otp4 __attribute__((swift_name("otp4")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> otp5 __attribute__((swift_name("otp5")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> otp6 __attribute__((swift_name("otp6")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> otpError __attribute__((swift_name("otpError")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> otpResend __attribute__((swift_name("otpResend")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> phone __attribute__((swift_name("phone")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> state __attribute__((swift_name("state")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> time __attribute__((swift_name("time")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreMutableStateFlow> transactionId __attribute__((swift_name("transactionId")));
@end

__attribute__((swift_name("AuthRepository")))
@protocol Auth_sharedAuthRepository
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)authorizationPhone:(NSString *)phone completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("authorization(phone:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)forgetPasswordEmail:(NSString *)email completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("forgetPassword(email:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)registerTrxid:(NSString *)trxid userReq:(Auth_sharedUserReq *)userReq imageBytes:(Auth_sharedKotlinByteArray * _Nullable)imageBytes imageName:(NSString * _Nullable)imageName completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("register(trxid:userReq:imageBytes:imageName:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)signInEmailEmail:(NSString *)email password:(NSString *)password completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("signInEmail(email:password:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)signInProviderAuthType:(Auth_sharedAuthType *)authType token:(NSString *)token userReq:(Auth_sharedUserReq * _Nullable)userReq completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("signInProvider(authType:token:userReq:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)signOutAccessToken:(NSString * _Nullable)accessToken completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("signOut(accessToken:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)validatePhonePhone:(NSString *)phone completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("validatePhone(phone:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)verifyOtpOtp:(NSString *)otp type:(NSString *)type phone:(NSString *)phone completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("verifyOtp(otp:type:phone:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthRepositoryImpl")))
@interface Auth_sharedAuthRepositoryImpl : Auth_sharedBase <Auth_sharedAuthRepository>
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig apiClientProvider:(id<Auth_sharedCore_sharedApiClientProvider>)apiClientProvider __attribute__((swift_name("init(authConfig:apiClientProvider:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)authorizationPhone:(NSString *)phone completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("authorization(phone:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)forgetPasswordEmail:(NSString *)email completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("forgetPassword(email:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)registerTrxid:(NSString *)trxid userReq:(Auth_sharedUserReq *)userReq imageBytes:(Auth_sharedKotlinByteArray * _Nullable)imageBytes imageName:(NSString * _Nullable)imageName completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("register(trxid:userReq:imageBytes:imageName:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)signInEmailEmail:(NSString *)email password:(NSString *)password completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("signInEmail(email:password:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)signInProviderAuthType:(Auth_sharedAuthType *)authType token:(NSString *)token userReq:(Auth_sharedUserReq * _Nullable)userReq completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("signInProvider(authType:token:userReq:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)signOutAccessToken:(NSString * _Nullable)accessToken completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("signOut(accessToken:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)validatePhonePhone:(NSString *)phone completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("validatePhone(phone:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)verifyOtpOtp:(NSString *)otp type:(NSString *)type phone:(NSString *)phone completionHandler:(void (^)(NSDictionary<NSString *, Auth_sharedKotlinx_serialization_jsonJsonElement *> * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("verifyOtp(otp:type:phone:completionHandler:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EmailReq")))
@interface Auth_sharedEmailReq : Auth_sharedBase
- (instancetype)initWithEmail:(NSString * _Nullable)email __attribute__((swift_name("init(email:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedEmailReqCompanion *companion __attribute__((swift_name("companion")));
- (Auth_sharedEmailReq *)doCopyEmail:(NSString * _Nullable)email __attribute__((swift_name("doCopy(email:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable email __attribute__((swift_name("email")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("EmailReq.Companion")))
@interface Auth_sharedEmailReqCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedEmailReqCompanion *shared __attribute__((swift_name("shared")));
- (id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignInByEmailReq")))
@interface Auth_sharedSignInByEmailReq : Auth_sharedBase
- (instancetype)initWithEmail:(NSString * _Nullable)email password:(NSString * _Nullable)password __attribute__((swift_name("init(email:password:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedSignInByEmailReqCompanion *companion __attribute__((swift_name("companion")));
- (Auth_sharedSignInByEmailReq *)doCopyEmail:(NSString * _Nullable)email password:(NSString * _Nullable)password __attribute__((swift_name("doCopy(email:password:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable email __attribute__((swift_name("email")));
@property (readonly) NSString * _Nullable password __attribute__((swift_name("password")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignInByEmailReq.Companion")))
@interface Auth_sharedSignInByEmailReqCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedSignInByEmailReqCompanion *shared __attribute__((swift_name("shared")));
- (id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignInByPhoneReq")))
@interface Auth_sharedSignInByPhoneReq : Auth_sharedBase
- (instancetype)initWithMsisdn:(NSString * _Nullable)msisdn __attribute__((swift_name("init(msisdn:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedSignInByPhoneReqCompanion *companion __attribute__((swift_name("companion")));
- (Auth_sharedSignInByPhoneReq *)doCopyMsisdn:(NSString * _Nullable)msisdn __attribute__((swift_name("doCopy(msisdn:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable msisdn __attribute__((swift_name("msisdn")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignInByPhoneReq.Companion")))
@interface Auth_sharedSignInByPhoneReqCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedSignInByPhoneReqCompanion *shared __attribute__((swift_name("shared")));
- (id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SigninProviderReq")))
@interface Auth_sharedSigninProviderReq : Auth_sharedBase
- (instancetype)initWithProvider:(NSString * _Nullable)provider email:(NSString * _Nullable)email fullname:(NSString * _Nullable)fullname subscriberAccess:(NSString *)subscriberAccess __attribute__((swift_name("init(provider:email:fullname:subscriberAccess:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedSigninProviderReqCompanion *companion __attribute__((swift_name("companion")));
- (Auth_sharedSigninProviderReq *)doCopyProvider:(NSString * _Nullable)provider email:(NSString * _Nullable)email fullname:(NSString * _Nullable)fullname subscriberAccess:(NSString *)subscriberAccess __attribute__((swift_name("doCopy(provider:email:fullname:subscriberAccess:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable email __attribute__((swift_name("email")));
@property (readonly) NSString * _Nullable fullname __attribute__((swift_name("fullname")));
@property (readonly) NSString * _Nullable provider __attribute__((swift_name("provider")));
@property (readonly) NSString *subscriberAccess __attribute__((swift_name("subscriberAccess")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SigninProviderReq.Companion")))
@interface Auth_sharedSigninProviderReqCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedSigninProviderReqCompanion *shared __attribute__((swift_name("shared")));
- (id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("UserReq")))
@interface Auth_sharedUserReq : Auth_sharedBase
- (instancetype)initWithId:(int32_t)id fullname:(NSString * _Nullable)fullname bio:(NSString * _Nullable)bio email:(NSString * _Nullable)email country:(NSString * _Nullable)country phone:(NSString * _Nullable)phone picture:(NSString * _Nullable)picture password:(NSString * _Nullable)password __attribute__((swift_name("init(id:fullname:bio:email:country:phone:picture:password:)"))) __attribute__((objc_designated_initializer));
- (Auth_sharedUserReq *)doCopyId:(int32_t)id fullname:(NSString * _Nullable)fullname bio:(NSString * _Nullable)bio email:(NSString * _Nullable)email country:(NSString * _Nullable)country phone:(NSString * _Nullable)phone picture:(NSString * _Nullable)picture password:(NSString * _Nullable)password __attribute__((swift_name("doCopy(id:fullname:bio:email:country:phone:picture:password:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable bio __attribute__((swift_name("bio")));
@property (readonly) NSString * _Nullable country __attribute__((swift_name("country")));
@property (readonly) NSString * _Nullable email __attribute__((swift_name("email")));
@property (readonly) NSString * _Nullable fullname __attribute__((swift_name("fullname")));
@property (readonly) int32_t id __attribute__((swift_name("id")));
@property NSString * _Nullable password __attribute__((swift_name("password")));
@property (readonly) NSString * _Nullable phone __attribute__((swift_name("phone")));
@property NSString * _Nullable picture __attribute__((swift_name("picture")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("VerifyOtpReq")))
@interface Auth_sharedVerifyOtpReq : Auth_sharedBase
- (instancetype)initWithOtp:(NSString * _Nullable)otp mode:(NSString * _Nullable)mode msisdn:(NSString * _Nullable)msisdn __attribute__((swift_name("init(otp:mode:msisdn:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedVerifyOtpReqCompanion *companion __attribute__((swift_name("companion")));
- (Auth_sharedVerifyOtpReq *)doCopyOtp:(NSString * _Nullable)otp mode:(NSString * _Nullable)mode msisdn:(NSString * _Nullable)msisdn __attribute__((swift_name("doCopy(otp:mode:msisdn:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString * _Nullable mode __attribute__((swift_name("mode")));
@property (readonly) NSString * _Nullable msisdn __attribute__((swift_name("msisdn")));
@property (readonly) NSString * _Nullable otp __attribute__((swift_name("otp")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("VerifyOtpReq.Companion")))
@interface Auth_sharedVerifyOtpReqCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedVerifyOtpReqCompanion *shared __attribute__((swift_name("shared")));
- (id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("AuthorizationUseCase")))
@interface Auth_sharedAuthorizationUseCase : Auth_sharedBase
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig authRepository:(id<Auth_sharedAuthRepository>)authRepository __attribute__((swift_name("init(authConfig:authRepository:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokePhone:(NSString *)phone completionHandler:(void (^)(Auth_sharedTicket * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(phone:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ForgetPasswordUseCase")))
@interface Auth_sharedForgetPasswordUseCase : Auth_sharedBase
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig authRepository:(id<Auth_sharedAuthRepository>)authRepository __attribute__((swift_name("init(authConfig:authRepository:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeEmail:(NSString *)email completionHandler:(void (^)(Auth_sharedTicket * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(email:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("RegisterUseCase")))
@interface Auth_sharedRegisterUseCase : Auth_sharedBase
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig authRepository:(id<Auth_sharedAuthRepository>)authRepository __attribute__((swift_name("init(authConfig:authRepository:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeTrxid:(NSString *)trxid userReq:(Auth_sharedUserReq *)userReq imageBytes:(Auth_sharedKotlinByteArray * _Nullable)imageBytes imageName:(NSString * _Nullable)imageName completionHandler:(void (^)(Auth_sharedTicket * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(trxid:userReq:imageBytes:imageName:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignInEmailUseCase")))
@interface Auth_sharedSignInEmailUseCase : Auth_sharedBase
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig authRepository:(id<Auth_sharedAuthRepository>)authRepository __attribute__((swift_name("init(authConfig:authRepository:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeEmail:(NSString *)email password:(NSString *)password completionHandler:(void (^)(Auth_sharedTicket * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(email:password:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignInProviderUseCase")))
@interface Auth_sharedSignInProviderUseCase : Auth_sharedBase
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig authRepository:(id<Auth_sharedAuthRepository>)authRepository __attribute__((swift_name("init(authConfig:authRepository:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeAuthType:(Auth_sharedAuthType *)authType token:(NSString *)token userReq:(Auth_sharedUserReq * _Nullable)userReq completionHandler:(void (^)(Auth_sharedTicket * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(authType:token:userReq:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("SignOutUseCase")))
@interface Auth_sharedSignOutUseCase : Auth_sharedBase
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig authRepository:(id<Auth_sharedAuthRepository>)authRepository __attribute__((swift_name("init(authConfig:authRepository:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeAccessToken:(NSString * _Nullable)accessToken completionHandler:(void (^)(Auth_sharedTicket * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(accessToken:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ValidatePhoneUseCase")))
@interface Auth_sharedValidatePhoneUseCase : Auth_sharedBase
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig authRepository:(id<Auth_sharedAuthRepository>)authRepository __attribute__((swift_name("init(authConfig:authRepository:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokePhone:(NSString *)phone completionHandler:(void (^)(Auth_sharedTicket * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(phone:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("VerifyOtpUseCase")))
@interface Auth_sharedVerifyOtpUseCase : Auth_sharedBase
- (instancetype)initWithAuthConfig:(id<Auth_sharedAuthConfig>)authConfig authRepository:(id<Auth_sharedAuthRepository>)authRepository __attribute__((swift_name("init(authConfig:authRepository:)"))) __attribute__((objc_designated_initializer));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)invokeOtp:(NSString *)otp type:(NSString *)type phone:(NSString *)phone completionHandler:(void (^)(Auth_sharedTicket * _Nullable_result, NSError * _Nullable))completionHandler __attribute__((swift_name("invoke(otp:type:phone:completionHandler:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("CountryCode")))
@interface Auth_sharedCountryCode : Auth_sharedBase
- (instancetype)initWithCode:(NSString *)code dialCode:(NSString *)dialCode countryName:(NSString *)countryName __attribute__((swift_name("init(code:dialCode:countryName:)"))) __attribute__((objc_designated_initializer));
- (Auth_sharedCountryCode *)doCopyCode:(NSString *)code dialCode:(NSString *)dialCode countryName:(NSString *)countryName __attribute__((swift_name("doCopy(code:dialCode:countryName:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) NSString *code __attribute__((swift_name("code")));
@property (readonly) NSString *countryName __attribute__((swift_name("countryName")));
@property (readonly) NSString *dialCode __attribute__((swift_name("dialCode")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Otp")))
@interface Auth_sharedOtp : Auth_sharedBase
- (instancetype)initWithDuration:(Auth_sharedLong * _Nullable)duration msisdn:(NSString * _Nullable)msisdn __attribute__((swift_name("init(duration:msisdn:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedOtpCompanion *companion __attribute__((swift_name("companion")));
- (Auth_sharedOtp *)doCopyDuration:(Auth_sharedLong * _Nullable)duration msisdn:(NSString * _Nullable)msisdn __attribute__((swift_name("doCopy(duration:msisdn:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property Auth_sharedLong * _Nullable duration __attribute__((swift_name("duration")));
@property NSString * _Nullable msisdn __attribute__((swift_name("msisdn")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Otp.Companion")))
@interface Auth_sharedOtpCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedOtpCompanion *shared __attribute__((swift_name("shared")));
- (id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Session")))
@interface Auth_sharedSession : Auth_sharedBase
- (instancetype)initWithUsername:(NSString * _Nullable)username msisdn:(NSString * _Nullable)msisdn role:(NSString * _Nullable)role id:(NSString * _Nullable)id email:(NSString * _Nullable)email fullname:(NSString * _Nullable)fullname expired:(Auth_sharedInt * _Nullable)expired status:(Auth_sharedInt * _Nullable)status token:(NSString * _Nullable)token refreshToken:(NSString * _Nullable)refreshToken isMsisdnVerified:(Auth_sharedBoolean * _Nullable)isMsisdnVerified isEmailVerified:(Auth_sharedBoolean * _Nullable)isEmailVerified isAccountVerified:(Auth_sharedBoolean * _Nullable)isAccountVerified permissions:(NSArray<NSString *> * _Nullable)permissions __attribute__((swift_name("init(username:msisdn:role:id:email:fullname:expired:status:token:refreshToken:isMsisdnVerified:isEmailVerified:isAccountVerified:permissions:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedSessionCompanion *companion __attribute__((swift_name("companion")));
- (Auth_sharedSession *)doCopyUsername:(NSString * _Nullable)username msisdn:(NSString * _Nullable)msisdn role:(NSString * _Nullable)role id:(NSString * _Nullable)id email:(NSString * _Nullable)email fullname:(NSString * _Nullable)fullname expired:(Auth_sharedInt * _Nullable)expired status:(Auth_sharedInt * _Nullable)status token:(NSString * _Nullable)token refreshToken:(NSString * _Nullable)refreshToken isMsisdnVerified:(Auth_sharedBoolean * _Nullable)isMsisdnVerified isEmailVerified:(Auth_sharedBoolean * _Nullable)isEmailVerified isAccountVerified:(Auth_sharedBoolean * _Nullable)isAccountVerified permissions:(NSArray<NSString *> * _Nullable)permissions __attribute__((swift_name("doCopy(username:msisdn:role:id:email:fullname:expired:status:token:refreshToken:isMsisdnVerified:isEmailVerified:isAccountVerified:permissions:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property NSString * _Nullable email __attribute__((swift_name("email")));
@property Auth_sharedInt * _Nullable expired __attribute__((swift_name("expired")));
@property NSString * _Nullable fullname __attribute__((swift_name("fullname")));
@property NSString * _Nullable id __attribute__((swift_name("id")));
@property Auth_sharedBoolean * _Nullable isAccountVerified __attribute__((swift_name("isAccountVerified")));
@property Auth_sharedBoolean * _Nullable isEmailVerified __attribute__((swift_name("isEmailVerified")));
@property Auth_sharedBoolean * _Nullable isMsisdnVerified __attribute__((swift_name("isMsisdnVerified")));
@property NSString * _Nullable msisdn __attribute__((swift_name("msisdn")));
@property NSArray<NSString *> * _Nullable permissions __attribute__((swift_name("permissions")));
@property NSString * _Nullable refreshToken __attribute__((swift_name("refreshToken")));
@property NSString * _Nullable role __attribute__((swift_name("role")));
@property Auth_sharedInt * _Nullable status __attribute__((swift_name("status")));
@property NSString * _Nullable token __attribute__((swift_name("token")));
@property NSString * _Nullable username __attribute__((swift_name("username")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Session.Companion")))
@interface Auth_sharedSessionCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedSessionCompanion *shared __attribute__((swift_name("shared")));
- (id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable
*/
__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ticket")))
@interface Auth_sharedTicket : Auth_sharedBase
- (instancetype)initWithTimestamp:(Auth_sharedLong * _Nullable)timestamp state:(NSString * _Nullable)state otp:(Auth_sharedOtp * _Nullable)otp session:(Auth_sharedSession * _Nullable)session transactionId:(NSString * _Nullable)transactionId __attribute__((swift_name("init(timestamp:state:otp:session:transactionId:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedTicketCompanion *companion __attribute__((swift_name("companion")));
- (Auth_sharedTicket *)doCopyTimestamp:(Auth_sharedLong * _Nullable)timestamp state:(NSString * _Nullable)state otp:(Auth_sharedOtp * _Nullable)otp session:(Auth_sharedSession * _Nullable)session transactionId:(NSString * _Nullable)transactionId __attribute__((swift_name("doCopy(timestamp:state:otp:session:transactionId:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property Auth_sharedOtp * _Nullable otp __attribute__((swift_name("otp")));
@property Auth_sharedSession * _Nullable session __attribute__((swift_name("session")));
@property NSString * _Nullable state __attribute__((swift_name("state")));
@property Auth_sharedLong * _Nullable timestamp __attribute__((swift_name("timestamp")));
@property NSString * _Nullable transactionId __attribute__((swift_name("transactionId")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ticket.Companion")))
@interface Auth_sharedTicketCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedTicketCompanion *shared __attribute__((swift_name("shared")));
- (id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("ActualKt")))
@interface Auth_sharedActualKt : Auth_sharedBase
+ (Auth_sharedKoin_coreModule *)authModule __attribute__((swift_name("authModule()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreModule")))
@interface Auth_sharedKoin_coreModule : Auth_sharedBase
- (instancetype)initWith_createdAtStart:(BOOL)_createdAtStart __attribute__((swift_name("init(_createdAtStart:)"))) __attribute__((objc_designated_initializer));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (Auth_sharedKoin_coreKoinDefinition<id> *)factoryQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(Auth_sharedKoin_coreScope *, Auth_sharedKoin_coreParametersHolder *))definition __attribute__((swift_name("factory(qualifier:definition:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (void)includesModule:(Auth_sharedKotlinArray<Auth_sharedKoin_coreModule *> *)module __attribute__((swift_name("includes(module:)")));
- (void)includesModule_:(NSArray<Auth_sharedKoin_coreModule *> *)module __attribute__((swift_name("includes(module_:)")));
- (void)indexPrimaryTypeInstanceFactory:(Auth_sharedKoin_coreInstanceFactory<id> *)instanceFactory __attribute__((swift_name("indexPrimaryType(instanceFactory:)")));
- (void)indexSecondaryTypesInstanceFactory:(Auth_sharedKoin_coreInstanceFactory<id> *)instanceFactory __attribute__((swift_name("indexSecondaryTypes(instanceFactory:)")));
- (NSArray<Auth_sharedKoin_coreModule *> *)plusModules:(NSArray<Auth_sharedKoin_coreModule *> *)modules __attribute__((swift_name("plus(modules:)")));
- (NSArray<Auth_sharedKoin_coreModule *> *)plusModule:(Auth_sharedKoin_coreModule *)module __attribute__((swift_name("plus(module:)")));
- (void)prepareForCreationAtStartInstanceFactory:(Auth_sharedKoin_coreSingleInstanceFactory<id> *)instanceFactory __attribute__((swift_name("prepareForCreationAtStart(instanceFactory:)")));
- (void)scopeQualifier:(id<Auth_sharedKoin_coreQualifier>)qualifier scopeSet:(void (^)(Auth_sharedKoin_coreScopeDSL *))scopeSet __attribute__((swift_name("scope(qualifier:scopeSet:)")));
- (void)scopeScopeSet:(void (^)(Auth_sharedKoin_coreScopeDSL *))scopeSet __attribute__((swift_name("scope(scopeSet:)")));
- (Auth_sharedKoin_coreKoinDefinition<id> *)singleQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier createdAtStart:(BOOL)createdAtStart definition:(id _Nullable (^)(Auth_sharedKoin_coreScope *, Auth_sharedKoin_coreParametersHolder *))definition __attribute__((swift_name("single(qualifier:createdAtStart:definition:)")));
@property (readonly) Auth_sharedMutableSet<Auth_sharedKoin_coreSingleInstanceFactory<id> *> *eagerInstances __attribute__((swift_name("eagerInstances")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) NSMutableArray<Auth_sharedKoin_coreModule *> *includedModules __attribute__((swift_name("includedModules")));
@property (readonly) BOOL isLoaded __attribute__((swift_name("isLoaded")));
@property (readonly) Auth_sharedMutableDictionary<NSString *, Auth_sharedKoin_coreInstanceFactory<id> *> *mappings __attribute__((swift_name("mappings")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.Serializable(with=NormalClass(value=kotlinx/serialization/json/JsonElementSerializer))
*/
__attribute__((swift_name("Kotlinx_serialization_jsonJsonElement")))
@interface Auth_sharedKotlinx_serialization_jsonJsonElement : Auth_sharedBase
@property (class, readonly, getter=companion) Auth_sharedKotlinx_serialization_jsonJsonElementCompanion *companion __attribute__((swift_name("companion")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinEnumCompanion")))
@interface Auth_sharedKotlinEnumCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedKotlinEnumCompanion *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinArray")))
@interface Auth_sharedKotlinArray<T> : Auth_sharedBase
+ (instancetype)arrayWithSize:(int32_t)size init:(T _Nullable (^)(Auth_sharedInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (T _Nullable)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (id<Auth_sharedKotlinIterator>)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(T _Nullable)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreFlow")))
@protocol Auth_sharedKotlinx_coroutines_coreFlow
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)collectCollector:(id<Auth_sharedKotlinx_coroutines_coreFlowCollector>)collector completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("collect(collector:completionHandler:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreSharedFlow")))
@protocol Auth_sharedKotlinx_coroutines_coreSharedFlow <Auth_sharedKotlinx_coroutines_coreFlow>
@required
@property (readonly) NSArray<id> *replayCache __attribute__((swift_name("replayCache")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreStateFlow")))
@protocol Auth_sharedKotlinx_coroutines_coreStateFlow <Auth_sharedKotlinx_coroutines_coreSharedFlow>
@required
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreFlowCollector")))
@protocol Auth_sharedKotlinx_coroutines_coreFlowCollector
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)emitValue:(id _Nullable)value completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("emit(value:completionHandler:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreMutableSharedFlow")))
@protocol Auth_sharedKotlinx_coroutines_coreMutableSharedFlow <Auth_sharedKotlinx_coroutines_coreSharedFlow, Auth_sharedKotlinx_coroutines_coreFlowCollector>
@required

/**
 * @note annotations
 *   kotlinx.coroutines.ExperimentalCoroutinesApi
*/
- (void)resetReplayCache __attribute__((swift_name("resetReplayCache()")));
- (BOOL)tryEmitValue:(id _Nullable)value __attribute__((swift_name("tryEmit(value:)")));
@property (readonly) id<Auth_sharedKotlinx_coroutines_coreStateFlow> subscriptionCount __attribute__((swift_name("subscriptionCount")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreMutableStateFlow")))
@protocol Auth_sharedKotlinx_coroutines_coreMutableStateFlow <Auth_sharedKotlinx_coroutines_coreStateFlow, Auth_sharedKotlinx_coroutines_coreMutableSharedFlow>
@required
- (BOOL)compareAndSetExpect:(id _Nullable)expect update:(id _Nullable)update __attribute__((swift_name("compareAndSet(expect:update:)")));
- (void)setValue:(id _Nullable)value __attribute__((swift_name("setValue(_:)")));
@end

__attribute__((swift_name("Kotlinx_coroutines_coreCoroutineScope")))
@protocol Auth_sharedKotlinx_coroutines_coreCoroutineScope
@required
@property (readonly) id<Auth_sharedKotlinCoroutineContext> coroutineContext __attribute__((swift_name("coroutineContext")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinByteArray")))
@interface Auth_sharedKotlinByteArray : Auth_sharedBase
+ (instancetype)arrayWithSize:(int32_t)size __attribute__((swift_name("init(size:)")));
+ (instancetype)arrayWithSize:(int32_t)size init:(Auth_sharedByte *(^)(Auth_sharedInt *))init __attribute__((swift_name("init(size:init:)")));
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (int8_t)getIndex:(int32_t)index __attribute__((swift_name("get(index:)")));
- (Auth_sharedKotlinByteIterator *)iterator __attribute__((swift_name("iterator()")));
- (void)setIndex:(int32_t)index value:(int8_t)value __attribute__((swift_name("set(index:value:)")));
@property (readonly) int32_t size __attribute__((swift_name("size")));
@end

__attribute__((swift_name("KotlinThrowable")))
@interface Auth_sharedKotlinThrowable : Auth_sharedBase
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));

/**
 * @note annotations
 *   kotlin.experimental.ExperimentalNativeApi
*/
- (Auth_sharedKotlinArray<NSString *> *)getStackTrace __attribute__((swift_name("getStackTrace()")));
- (void)printStackTrace __attribute__((swift_name("printStackTrace()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) Auth_sharedKotlinThrowable * _Nullable cause __attribute__((swift_name("cause")));
@property (readonly) NSString * _Nullable message __attribute__((swift_name("message")));
- (NSError *)asError __attribute__((swift_name("asError()")));
@end

__attribute__((swift_name("KotlinException")))
@interface Auth_sharedKotlinException : Auth_sharedKotlinThrowable
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinRuntimeException")))
@interface Auth_sharedKotlinRuntimeException : Auth_sharedKotlinException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("KotlinIllegalStateException")))
@interface Auth_sharedKotlinIllegalStateException : Auth_sharedKotlinRuntimeException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.4")
*/
__attribute__((swift_name("KotlinCancellationException")))
@interface Auth_sharedKotlinCancellationException : Auth_sharedKotlinIllegalStateException
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (instancetype)initWithMessage:(NSString * _Nullable)message __attribute__((swift_name("init(message:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithMessage:(NSString * _Nullable)message cause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(message:cause:)"))) __attribute__((objc_designated_initializer));
- (instancetype)initWithCause:(Auth_sharedKotlinThrowable * _Nullable)cause __attribute__((swift_name("init(cause:)"))) __attribute__((objc_designated_initializer));
@end

__attribute__((swift_name("Core_sharedApiClientProvider")))
@protocol Auth_sharedCore_sharedApiClientProvider
@required
@property (readonly) id _Nullable client __attribute__((swift_name("client")));
@property (readonly) NSObject * _Nullable context __attribute__((swift_name("context")));
@property (readonly) id<Auth_sharedCore_sharedCoreConfig> coreConfig __attribute__((swift_name("coreConfig")));
@property (readonly) NSString *deviceId __attribute__((swift_name("deviceId")));
@property (readonly) Auth_sharedKotlinx_serialization_jsonJson *json __attribute__((swift_name("json")));
@property (readonly) id<Auth_sharedCore_sharedRefreshTokenUseCase> _Nullable refreshTokenUseCase __attribute__((swift_name("refreshTokenUseCase")));
@property (readonly) NSString *server __attribute__((swift_name("server")));
@property (readonly) Auth_sharedKtor_httpURLProtocol * _Nullable serverProtocol __attribute__((swift_name("serverProtocol")));
@property (readonly) NSString *sharedPrefsKey __attribute__((swift_name("sharedPrefsKey")));
@property (readonly) NSString *version __attribute__((swift_name("version")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializationStrategy")))
@protocol Auth_sharedKotlinx_serialization_coreSerializationStrategy
@required
- (void)serializeEncoder:(id<Auth_sharedKotlinx_serialization_coreEncoder>)encoder value:(id _Nullable)value __attribute__((swift_name("serialize(encoder:value:)")));
@property (readonly) id<Auth_sharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDeserializationStrategy")))
@protocol Auth_sharedKotlinx_serialization_coreDeserializationStrategy
@required
- (id _Nullable)deserializeDecoder:(id<Auth_sharedKotlinx_serialization_coreDecoder>)decoder __attribute__((swift_name("deserialize(decoder:)")));
@property (readonly) id<Auth_sharedKotlinx_serialization_coreSerialDescriptor> descriptor __attribute__((swift_name("descriptor")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreKSerializer")))
@protocol Auth_sharedKotlinx_serialization_coreKSerializer <Auth_sharedKotlinx_serialization_coreSerializationStrategy, Auth_sharedKotlinx_serialization_coreDeserializationStrategy>
@required
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKoinDefinition")))
@interface Auth_sharedKoin_coreKoinDefinition<R> : Auth_sharedBase
- (instancetype)initWithModule:(Auth_sharedKoin_coreModule *)module factory:(Auth_sharedKoin_coreInstanceFactory<R> *)factory __attribute__((swift_name("init(module:factory:)"))) __attribute__((objc_designated_initializer));
- (Auth_sharedKoin_coreKoinDefinition<R> *)doCopyModule:(Auth_sharedKoin_coreModule *)module factory:(Auth_sharedKoin_coreInstanceFactory<R> *)factory __attribute__((swift_name("doCopy(module:factory:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) Auth_sharedKoin_coreInstanceFactory<R> *factory __attribute__((swift_name("factory")));
@property (readonly) Auth_sharedKoin_coreModule *module __attribute__((swift_name("module")));
@end

__attribute__((swift_name("Koin_coreQualifier")))
@protocol Auth_sharedKoin_coreQualifier
@required
@property (readonly) NSString *value __attribute__((swift_name("value")));
@end

__attribute__((swift_name("Koin_coreLockable")))
@interface Auth_sharedKoin_coreLockable : Auth_sharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScope")))
@interface Auth_sharedKoin_coreScope : Auth_sharedKoin_coreLockable
- (instancetype)initWithScopeQualifier:(id<Auth_sharedKoin_coreQualifier>)scopeQualifier id:(NSString *)id isRoot:(BOOL)isRoot _koin:(Auth_sharedKoin_coreKoin *)_koin __attribute__((swift_name("init(scopeQualifier:id:isRoot:_koin:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
- (void)close __attribute__((swift_name("close()")));
- (Auth_sharedKoin_coreScope *)doCopyScopeQualifier:(id<Auth_sharedKoin_coreQualifier>)scopeQualifier id:(NSString *)id isRoot:(BOOL)isRoot _koin:(Auth_sharedKoin_coreKoin *)_koin __attribute__((swift_name("doCopy(scopeQualifier:id:isRoot:_koin:)")));
- (void)declareInstance:(id _Nullable)instance qualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier secondaryTypes:(NSArray<id<Auth_sharedKotlinKClass>> *)secondaryTypes allowOverride:(BOOL)allowOverride __attribute__((swift_name("declare(instance:qualifier:secondaryTypes:allowOverride:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (id _Nullable)getClazz:(id<Auth_sharedKotlinKClass>)clazz qualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(clazz:qualifier:parameters:)")));
- (id)getQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(qualifier:parameters:)")));
- (NSArray<id> *)getAll __attribute__((swift_name("getAll()")));
- (NSArray<id> *)getAllClazz:(id<Auth_sharedKotlinKClass>)clazz __attribute__((swift_name("getAll(clazz:)")));
- (Auth_sharedKoin_coreKoin *)getKoin __attribute__((swift_name("getKoin()")));
- (id _Nullable)getOrNullClazz:(id<Auth_sharedKotlinKClass>)clazz qualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(clazz:qualifier:parameters:)")));
- (id _Nullable)getOrNullQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(qualifier:parameters:)")));
- (id)getPropertyKey:(NSString *)key __attribute__((swift_name("getProperty(key:)")));
- (id)getPropertyKey:(NSString *)key defaultValue:(id)defaultValue __attribute__((swift_name("getProperty(key:defaultValue:)")));
- (id _Nullable)getPropertyOrNullKey:(NSString *)key __attribute__((swift_name("getPropertyOrNull(key:)")));
- (Auth_sharedKoin_coreScope *)getScopeScopeID:(NSString *)scopeID __attribute__((swift_name("getScope(scopeID:)")));
- (id _Nullable)getSource __attribute__((swift_name("getSource()"))) __attribute__((deprecated("No need to use getSource(). You can an use get() directly.")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (id<Auth_sharedKotlinLazy>)injectQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier mode:(Auth_sharedKotlinLazyThreadSafetyMode *)mode parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("inject(qualifier:mode:parameters:)")));
- (id<Auth_sharedKotlinLazy>)injectOrNullQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier mode:(Auth_sharedKotlinLazyThreadSafetyMode *)mode parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("injectOrNull(qualifier:mode:parameters:)")));
- (BOOL)isNotClosed __attribute__((swift_name("isNotClosed()")));
- (void)linkToScopes:(Auth_sharedKotlinArray<Auth_sharedKoin_coreScope *> *)scopes __attribute__((swift_name("linkTo(scopes:)")));
- (void)registerCallbackCallback:(id<Auth_sharedKoin_coreScopeCallback>)callback __attribute__((swift_name("registerCallback(callback:)")));
- (NSString *)description __attribute__((swift_name("description()")));
- (void)unlinkScopes:(Auth_sharedKotlinArray<Auth_sharedKoin_coreScope *> *)scopes __attribute__((swift_name("unlink(scopes:)")));
@property (readonly) NSMutableArray<Auth_sharedKoin_coreParametersHolder *> *_parameterStack __attribute__((swift_name("_parameterStack")));
@property id _Nullable _source __attribute__((swift_name("_source")));
@property (readonly) BOOL closed __attribute__((swift_name("closed")));
@property (readonly) NSString *id __attribute__((swift_name("id")));
@property (readonly) BOOL isRoot __attribute__((swift_name("isRoot")));
@property (readonly) Auth_sharedKoin_coreLogger *logger __attribute__((swift_name("logger")));
@property (readonly) id<Auth_sharedKoin_coreQualifier> scopeQualifier __attribute__((swift_name("scopeQualifier")));
@end

__attribute__((swift_name("Koin_coreParametersHolder")))
@interface Auth_sharedKoin_coreParametersHolder : Auth_sharedBase
- (instancetype)initWith_values:(NSMutableArray<id> *)_values useIndexedValues:(Auth_sharedBoolean * _Nullable)useIndexedValues __attribute__((swift_name("init(_values:useIndexedValues:)"))) __attribute__((objc_designated_initializer));
- (Auth_sharedKoin_coreParametersHolder *)addValue:(id)value __attribute__((swift_name("add(value:)")));
- (id _Nullable)component1 __attribute__((swift_name("component1()")));
- (id _Nullable)component2 __attribute__((swift_name("component2()")));
- (id _Nullable)component3 __attribute__((swift_name("component3()")));
- (id _Nullable)component4 __attribute__((swift_name("component4()")));
- (id _Nullable)component5 __attribute__((swift_name("component5()")));
- (id _Nullable)elementAtI:(int32_t)i clazz:(id<Auth_sharedKotlinKClass>)clazz __attribute__((swift_name("elementAt(i:clazz:)")));
- (id)get __attribute__((swift_name("get()")));
- (id _Nullable)getI:(int32_t)i __attribute__((swift_name("get(i:)")));
- (id _Nullable)getOrNull __attribute__((swift_name("getOrNull()")));
- (id _Nullable)getOrNullClazz:(id<Auth_sharedKotlinKClass>)clazz __attribute__((swift_name("getOrNull(clazz:)")));
- (Auth_sharedKoin_coreParametersHolder *)insertIndex:(int32_t)index value:(id)value __attribute__((swift_name("insert(index:value:)")));
- (BOOL)isEmpty __attribute__((swift_name("isEmpty()")));
- (BOOL)isNotEmpty __attribute__((swift_name("isNotEmpty()")));
- (void)setI:(int32_t)i t:(id _Nullable)t __attribute__((swift_name("set(i:t:)")));
- (int32_t)size __attribute__((swift_name("size()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property int32_t index __attribute__((swift_name("index")));
@property (readonly) Auth_sharedBoolean * _Nullable useIndexedValues __attribute__((swift_name("useIndexedValues")));
@property (readonly) NSArray<id> *values __attribute__((swift_name("values")));
@end

__attribute__((swift_name("Koin_coreInstanceFactory")))
@interface Auth_sharedKoin_coreInstanceFactory<T> : Auth_sharedKoin_coreLockable
- (instancetype)initWithBeanDefinition:(Auth_sharedKoin_coreBeanDefinition<T> *)beanDefinition __attribute__((swift_name("init(beanDefinition:)"))) __attribute__((objc_designated_initializer));
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
+ (instancetype)new __attribute__((unavailable));
@property (class, readonly, getter=companion) Auth_sharedKoin_coreInstanceFactoryCompanion *companion __attribute__((swift_name("companion")));
- (T _Nullable)createContext:(Auth_sharedKoin_coreInstanceContext *)context __attribute__((swift_name("create(context:)")));
- (void)dropScope:(Auth_sharedKoin_coreScope * _Nullable)scope __attribute__((swift_name("drop(scope:)")));
- (void)dropAll __attribute__((swift_name("dropAll()")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (T _Nullable)getContext:(Auth_sharedKoin_coreInstanceContext *)context __attribute__((swift_name("get(context:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)isCreatedContext:(Auth_sharedKoin_coreInstanceContext * _Nullable)context __attribute__((swift_name("isCreated(context:)")));
@property (readonly) Auth_sharedKoin_coreBeanDefinition<T> *beanDefinition __attribute__((swift_name("beanDefinition")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreSingleInstanceFactory")))
@interface Auth_sharedKoin_coreSingleInstanceFactory<T> : Auth_sharedKoin_coreInstanceFactory<T>
- (instancetype)initWithBeanDefinition:(Auth_sharedKoin_coreBeanDefinition<T> *)beanDefinition __attribute__((swift_name("init(beanDefinition:)"))) __attribute__((objc_designated_initializer));
- (T _Nullable)createContext:(Auth_sharedKoin_coreInstanceContext *)context __attribute__((swift_name("create(context:)")));
- (void)dropScope:(Auth_sharedKoin_coreScope * _Nullable)scope __attribute__((swift_name("drop(scope:)")));
- (void)dropAll __attribute__((swift_name("dropAll()")));
- (T _Nullable)getContext:(Auth_sharedKoin_coreInstanceContext *)context __attribute__((swift_name("get(context:)")));
- (BOOL)isCreatedContext:(Auth_sharedKoin_coreInstanceContext * _Nullable)context __attribute__((swift_name("isCreated(context:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScopeDSL")))
@interface Auth_sharedKoin_coreScopeDSL : Auth_sharedBase
- (instancetype)initWithScopeQualifier:(id<Auth_sharedKoin_coreQualifier>)scopeQualifier module:(Auth_sharedKoin_coreModule *)module __attribute__((swift_name("init(scopeQualifier:module:)"))) __attribute__((objc_designated_initializer));
- (Auth_sharedKoin_coreKoinDefinition<id> *)factoryQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(Auth_sharedKoin_coreScope *, Auth_sharedKoin_coreParametersHolder *))definition __attribute__((swift_name("factory(qualifier:definition:)")));
- (Auth_sharedKoin_coreKoinDefinition<id> *)scopedQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier definition:(id _Nullable (^)(Auth_sharedKoin_coreScope *, Auth_sharedKoin_coreParametersHolder *))definition __attribute__((swift_name("scoped(qualifier:definition:)")));
@property (readonly) Auth_sharedKoin_coreModule *module __attribute__((swift_name("module")));
@property (readonly) id<Auth_sharedKoin_coreQualifier> scopeQualifier __attribute__((swift_name("scopeQualifier")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJsonElement.Companion")))
@interface Auth_sharedKotlinx_serialization_jsonJsonElementCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedKotlinx_serialization_jsonJsonElementCompanion *shared __attribute__((swift_name("shared")));
- (id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("serializer()")));
@end

__attribute__((swift_name("KotlinIterator")))
@protocol Auth_sharedKotlinIterator
@required
- (BOOL)hasNext __attribute__((swift_name("hasNext()")));
- (id _Nullable)next __attribute__((swift_name("next()")));
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.3")
*/
__attribute__((swift_name("KotlinCoroutineContext")))
@protocol Auth_sharedKotlinCoroutineContext
@required
- (id _Nullable)foldInitial:(id _Nullable)initial operation:(id _Nullable (^)(id _Nullable, id<Auth_sharedKotlinCoroutineContextElement>))operation __attribute__((swift_name("fold(initial:operation:)")));
- (id<Auth_sharedKotlinCoroutineContextElement> _Nullable)getKey:(id<Auth_sharedKotlinCoroutineContextKey>)key __attribute__((swift_name("get(key:)")));
- (id<Auth_sharedKotlinCoroutineContext>)minusKeyKey:(id<Auth_sharedKotlinCoroutineContextKey>)key __attribute__((swift_name("minusKey(key:)")));
- (id<Auth_sharedKotlinCoroutineContext>)plusContext:(id<Auth_sharedKotlinCoroutineContext>)context __attribute__((swift_name("plus(context:)")));
@end

__attribute__((swift_name("KotlinByteIterator")))
@interface Auth_sharedKotlinByteIterator : Auth_sharedBase <Auth_sharedKotlinIterator>
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (Auth_sharedByte *)next __attribute__((swift_name("next()")));
- (int8_t)nextByte __attribute__((swift_name("nextByte()")));
@end

__attribute__((swift_name("Core_sharedCoreConfig")))
@protocol Auth_sharedCore_sharedCoreConfig
@required
@property (readonly) NSString * _Nullable apiAuthPath __attribute__((swift_name("apiAuthPath")));
@property (readonly) NSString * _Nullable apiChannel __attribute__((swift_name("apiChannel")));
@property (readonly) NSString * _Nullable apiRefreshTokenPath __attribute__((swift_name("apiRefreshTokenPath")));
@property (readonly) NSString * _Nullable headerChannel __attribute__((swift_name("headerChannel")));
@property (readonly) NSString * _Nullable headerDeviceId __attribute__((swift_name("headerDeviceId")));
@property (readonly) NSString * _Nullable headerLanguage __attribute__((swift_name("headerLanguage")));
@property (readonly) NSString * _Nullable headerOs __attribute__((swift_name("headerOs")));
@property (readonly) NSString * _Nullable headerVersion __attribute__((swift_name("headerVersion")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerialFormat")))
@protocol Auth_sharedKotlinx_serialization_coreSerialFormat
@required
@property (readonly) Auth_sharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreStringFormat")))
@protocol Auth_sharedKotlinx_serialization_coreStringFormat <Auth_sharedKotlinx_serialization_coreSerialFormat>
@required
- (id _Nullable)decodeFromStringDeserializer:(id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy>)deserializer string:(NSString *)string __attribute__((swift_name("decodeFromString(deserializer:string:)")));
- (NSString *)encodeToStringSerializer:(id<Auth_sharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeToString(serializer:value:)")));
@end

__attribute__((swift_name("Kotlinx_serialization_jsonJson")))
@interface Auth_sharedKotlinx_serialization_jsonJson : Auth_sharedBase <Auth_sharedKotlinx_serialization_coreStringFormat>
@property (class, readonly, getter=companion) Auth_sharedKotlinx_serialization_jsonJsonDefault *companion __attribute__((swift_name("companion")));
- (id _Nullable)decodeFromJsonElementDeserializer:(id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy>)deserializer element:(Auth_sharedKotlinx_serialization_jsonJsonElement *)element __attribute__((swift_name("decodeFromJsonElement(deserializer:element:)")));
- (id _Nullable)decodeFromStringString:(NSString *)string __attribute__((swift_name("decodeFromString(string:)")));
- (id _Nullable)decodeFromStringDeserializer:(id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy>)deserializer string:(NSString *)string __attribute__((swift_name("decodeFromString(deserializer:string:)")));
- (Auth_sharedKotlinx_serialization_jsonJsonElement *)encodeToJsonElementSerializer:(id<Auth_sharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeToJsonElement(serializer:value:)")));
- (NSString *)encodeToStringSerializer:(id<Auth_sharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeToString(serializer:value:)")));
- (Auth_sharedKotlinx_serialization_jsonJsonElement *)parseToJsonElementString:(NSString *)string __attribute__((swift_name("parseToJsonElement(string:)")));
@property (readonly) Auth_sharedKotlinx_serialization_jsonJsonConfiguration *configuration __attribute__((swift_name("configuration")));
@property (readonly) Auth_sharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Core_sharedCoreUseCase")))
@protocol Auth_sharedCore_sharedCoreUseCase
@required

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)callArgs:(Auth_sharedKotlinArray<id> *)args completionHandler:(void (^)(id _Nullable, NSError * _Nullable))completionHandler __attribute__((swift_name("call(args:completionHandler:)")));

/**
 * @note This method converts instances of CancellationException to errors.
 * Other uncaught Kotlin exceptions are fatal.
*/
- (void)onErrorE:(Auth_sharedKotlinException *)e completionHandler:(void (^)(NSError * _Nullable))completionHandler __attribute__((swift_name("onError(e:completionHandler:)")));
@end

__attribute__((swift_name("Core_sharedRefreshTokenUseCase")))
@protocol Auth_sharedCore_sharedRefreshTokenUseCase <Auth_sharedCore_sharedCoreUseCase>
@required
@property (getter=doNewRefreshToken) NSString *newRefreshToken __attribute__((swift_name("newRefreshToken")));
@property (getter=doNewToken) NSString *newToken __attribute__((swift_name("newToken")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLProtocol")))
@interface Auth_sharedKtor_httpURLProtocol : Auth_sharedBase
- (instancetype)initWithName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("init(name:defaultPort:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedKtor_httpURLProtocolCompanion *companion __attribute__((swift_name("companion")));
- (Auth_sharedKtor_httpURLProtocol *)doCopyName:(NSString *)name defaultPort:(int32_t)defaultPort __attribute__((swift_name("doCopy(name:defaultPort:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) int32_t defaultPort __attribute__((swift_name("defaultPort")));
@property (readonly) NSString *name __attribute__((swift_name("name")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreEncoder")))
@protocol Auth_sharedKotlinx_serialization_coreEncoder
@required
- (id<Auth_sharedKotlinx_serialization_coreCompositeEncoder>)beginCollectionDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor collectionSize:(int32_t)collectionSize __attribute__((swift_name("beginCollection(descriptor:collectionSize:)")));
- (id<Auth_sharedKotlinx_serialization_coreCompositeEncoder>)beginStructureDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (void)encodeBooleanValue:(BOOL)value __attribute__((swift_name("encodeBoolean(value:)")));
- (void)encodeByteValue:(int8_t)value __attribute__((swift_name("encodeByte(value:)")));
- (void)encodeCharValue:(unichar)value __attribute__((swift_name("encodeChar(value:)")));
- (void)encodeDoubleValue:(double)value __attribute__((swift_name("encodeDouble(value:)")));
- (void)encodeEnumEnumDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)enumDescriptor index:(int32_t)index __attribute__((swift_name("encodeEnum(enumDescriptor:index:)")));
- (void)encodeFloatValue:(float)value __attribute__((swift_name("encodeFloat(value:)")));
- (id<Auth_sharedKotlinx_serialization_coreEncoder>)encodeInlineDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("encodeInline(descriptor:)")));
- (void)encodeIntValue:(int32_t)value __attribute__((swift_name("encodeInt(value:)")));
- (void)encodeLongValue:(int64_t)value __attribute__((swift_name("encodeLong(value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNotNullMark __attribute__((swift_name("encodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNull __attribute__((swift_name("encodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableValueSerializer:(id<Auth_sharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableValue(serializer:value:)")));
- (void)encodeSerializableValueSerializer:(id<Auth_sharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableValue(serializer:value:)")));
- (void)encodeShortValue:(int16_t)value __attribute__((swift_name("encodeShort(value:)")));
- (void)encodeStringValue:(NSString *)value __attribute__((swift_name("encodeString(value:)")));
@property (readonly) Auth_sharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerialDescriptor")))
@protocol Auth_sharedKotlinx_serialization_coreSerialDescriptor
@required

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSArray<id<Auth_sharedKotlinAnnotation>> *)getElementAnnotationsIndex:(int32_t)index __attribute__((swift_name("getElementAnnotations(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)getElementDescriptorIndex:(int32_t)index __attribute__((swift_name("getElementDescriptor(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (int32_t)getElementIndexName:(NSString *)name __attribute__((swift_name("getElementIndex(name:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (NSString *)getElementNameIndex:(int32_t)index __attribute__((swift_name("getElementName(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)isElementOptionalIndex:(int32_t)index __attribute__((swift_name("isElementOptional(index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSArray<id<Auth_sharedKotlinAnnotation>> *annotations __attribute__((swift_name("annotations")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) int32_t elementsCount __attribute__((swift_name("elementsCount")));
@property (readonly) BOOL isInline __attribute__((swift_name("isInline")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) BOOL isNullable __attribute__((swift_name("isNullable")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) Auth_sharedKotlinx_serialization_coreSerialKind *kind __attribute__((swift_name("kind")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSString *serialName __attribute__((swift_name("serialName")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreDecoder")))
@protocol Auth_sharedKotlinx_serialization_coreDecoder
@required
- (id<Auth_sharedKotlinx_serialization_coreCompositeDecoder>)beginStructureDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("beginStructure(descriptor:)")));
- (BOOL)decodeBoolean __attribute__((swift_name("decodeBoolean()")));
- (int8_t)decodeByte __attribute__((swift_name("decodeByte()")));
- (unichar)decodeChar __attribute__((swift_name("decodeChar()")));
- (double)decodeDouble __attribute__((swift_name("decodeDouble()")));
- (int32_t)decodeEnumEnumDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)enumDescriptor __attribute__((swift_name("decodeEnum(enumDescriptor:)")));
- (float)decodeFloat __attribute__((swift_name("decodeFloat()")));
- (id<Auth_sharedKotlinx_serialization_coreDecoder>)decodeInlineDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeInline(descriptor:)")));
- (int32_t)decodeInt __attribute__((swift_name("decodeInt()")));
- (int64_t)decodeLong __attribute__((swift_name("decodeLong()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeNotNullMark __attribute__((swift_name("decodeNotNullMark()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (Auth_sharedKotlinNothing * _Nullable)decodeNull __attribute__((swift_name("decodeNull()")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableValueDeserializer:(id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeNullableSerializableValue(deserializer:)")));
- (id _Nullable)decodeSerializableValueDeserializer:(id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy>)deserializer __attribute__((swift_name("decodeSerializableValue(deserializer:)")));
- (int16_t)decodeShort __attribute__((swift_name("decodeShort()")));
- (NSString *)decodeString __attribute__((swift_name("decodeString()")));
@property (readonly) Auth_sharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKoin")))
@interface Auth_sharedKoin_coreKoin : Auth_sharedBase
- (instancetype)init __attribute__((swift_name("init()"))) __attribute__((objc_designated_initializer));
+ (instancetype)new __attribute__((availability(swift, unavailable, message="use object initializers instead")));
- (void)close __attribute__((swift_name("close()")));
- (void)createEagerInstances __attribute__((swift_name("createEagerInstances()")));
- (Auth_sharedKoin_coreScope *)createScopeT:(id<Auth_sharedKoin_coreKoinScopeComponent>)t __attribute__((swift_name("createScope(t:)")));
- (Auth_sharedKoin_coreScope *)createScopeScopeId:(NSString *)scopeId __attribute__((swift_name("createScope(scopeId:)")));
- (Auth_sharedKoin_coreScope *)createScopeScopeId:(NSString *)scopeId source:(id _Nullable)source __attribute__((swift_name("createScope(scopeId:source:)")));
- (Auth_sharedKoin_coreScope *)createScopeScopeId:(NSString *)scopeId qualifier:(id<Auth_sharedKoin_coreQualifier>)qualifier source:(id _Nullable)source __attribute__((swift_name("createScope(scopeId:qualifier:source:)")));
- (void)declareInstance:(id _Nullable)instance qualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier secondaryTypes:(NSArray<id<Auth_sharedKotlinKClass>> *)secondaryTypes allowOverride:(BOOL)allowOverride __attribute__((swift_name("declare(instance:qualifier:secondaryTypes:allowOverride:)")));
- (void)deletePropertyKey:(NSString *)key __attribute__((swift_name("deleteProperty(key:)")));
- (void)deleteScopeScopeId:(NSString *)scopeId __attribute__((swift_name("deleteScope(scopeId:)")));
- (id _Nullable)getClazz:(id<Auth_sharedKotlinKClass>)clazz qualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(clazz:qualifier:parameters:)")));
- (id)getQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("get(qualifier:parameters:)")));
- (NSArray<id> *)getAll __attribute__((swift_name("getAll()")));
- (Auth_sharedKoin_coreScope *)getOrCreateScopeScopeId:(NSString *)scopeId __attribute__((swift_name("getOrCreateScope(scopeId:)")));
- (Auth_sharedKoin_coreScope *)getOrCreateScopeScopeId:(NSString *)scopeId qualifier:(id<Auth_sharedKoin_coreQualifier>)qualifier source:(id _Nullable)source __attribute__((swift_name("getOrCreateScope(scopeId:qualifier:source:)")));
- (id _Nullable)getOrNullClazz:(id<Auth_sharedKotlinKClass>)clazz qualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(clazz:qualifier:parameters:)")));
- (id _Nullable)getOrNullQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("getOrNull(qualifier:parameters:)")));
- (id _Nullable)getPropertyKey:(NSString *)key __attribute__((swift_name("getProperty(key:)")));
- (id)getPropertyKey:(NSString *)key defaultValue:(id)defaultValue __attribute__((swift_name("getProperty(key:defaultValue:)")));
- (Auth_sharedKoin_coreScope *)getScopeScopeId:(NSString *)scopeId __attribute__((swift_name("getScope(scopeId:)")));
- (Auth_sharedKoin_coreScope * _Nullable)getScopeOrNullScopeId:(NSString *)scopeId __attribute__((swift_name("getScopeOrNull(scopeId:)")));
- (id<Auth_sharedKotlinLazy>)injectQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier mode:(Auth_sharedKotlinLazyThreadSafetyMode *)mode parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("inject(qualifier:mode:parameters:)")));
- (id<Auth_sharedKotlinLazy>)injectOrNullQualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier mode:(Auth_sharedKotlinLazyThreadSafetyMode *)mode parameters:(Auth_sharedKoin_coreParametersHolder *(^ _Nullable)(void))parameters __attribute__((swift_name("injectOrNull(qualifier:mode:parameters:)")));
- (void)loadModulesModules:(NSArray<Auth_sharedKoin_coreModule *> *)modules allowOverride:(BOOL)allowOverride __attribute__((swift_name("loadModules(modules:allowOverride:)")));
- (void)setPropertyKey:(NSString *)key value:(id)value __attribute__((swift_name("setProperty(key:value:)")));
- (void)setupLoggerLogger:(Auth_sharedKoin_coreLogger *)logger __attribute__((swift_name("setupLogger(logger:)")));
- (void)unloadModulesModules:(NSArray<Auth_sharedKoin_coreModule *> *)modules __attribute__((swift_name("unloadModules(modules:)")));
@property (readonly) Auth_sharedKoin_coreExtensionManager *extensionManager __attribute__((swift_name("extensionManager")));
@property (readonly) Auth_sharedKoin_coreInstanceRegistry *instanceRegistry __attribute__((swift_name("instanceRegistry")));
@property (readonly) Auth_sharedKoin_coreLogger *logger __attribute__((swift_name("logger")));
@property (readonly) Auth_sharedKoin_corePropertyRegistry *propertyRegistry __attribute__((swift_name("propertyRegistry")));
@property (readonly) Auth_sharedKoin_coreScopeRegistry *scopeRegistry __attribute__((swift_name("scopeRegistry")));
@end

__attribute__((swift_name("KotlinKDeclarationContainer")))
@protocol Auth_sharedKotlinKDeclarationContainer
@required
@end

__attribute__((swift_name("KotlinKAnnotatedElement")))
@protocol Auth_sharedKotlinKAnnotatedElement
@required
@end


/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
__attribute__((swift_name("KotlinKClassifier")))
@protocol Auth_sharedKotlinKClassifier
@required
@end

__attribute__((swift_name("KotlinKClass")))
@protocol Auth_sharedKotlinKClass <Auth_sharedKotlinKDeclarationContainer, Auth_sharedKotlinKAnnotatedElement, Auth_sharedKotlinKClassifier>
@required

/**
 * @note annotations
 *   kotlin.SinceKotlin(version="1.1")
*/
- (BOOL)isInstanceValue:(id _Nullable)value __attribute__((swift_name("isInstance(value:)")));
@property (readonly) NSString * _Nullable qualifiedName __attribute__((swift_name("qualifiedName")));
@property (readonly) NSString * _Nullable simpleName __attribute__((swift_name("simpleName")));
@end

__attribute__((swift_name("KotlinLazy")))
@protocol Auth_sharedKotlinLazy
@required
- (BOOL)isInitialized __attribute__((swift_name("isInitialized()")));
@property (readonly) id _Nullable value __attribute__((swift_name("value")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinLazyThreadSafetyMode")))
@interface Auth_sharedKotlinLazyThreadSafetyMode : Auth_sharedKotlinEnum<Auth_sharedKotlinLazyThreadSafetyMode *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) Auth_sharedKotlinLazyThreadSafetyMode *synchronized __attribute__((swift_name("synchronized")));
@property (class, readonly) Auth_sharedKotlinLazyThreadSafetyMode *publication __attribute__((swift_name("publication")));
@property (class, readonly) Auth_sharedKotlinLazyThreadSafetyMode *none __attribute__((swift_name("none")));
+ (Auth_sharedKotlinArray<Auth_sharedKotlinLazyThreadSafetyMode *> *)values __attribute__((swift_name("values()")));
@property (class, readonly) NSArray<Auth_sharedKotlinLazyThreadSafetyMode *> *entries __attribute__((swift_name("entries")));
@end

__attribute__((swift_name("Koin_coreScopeCallback")))
@protocol Auth_sharedKoin_coreScopeCallback
@required
- (void)onScopeCloseScope:(Auth_sharedKoin_coreScope *)scope __attribute__((swift_name("onScopeClose(scope:)")));
@end

__attribute__((swift_name("Koin_coreLogger")))
@interface Auth_sharedKoin_coreLogger : Auth_sharedBase
- (instancetype)initWithLevel:(Auth_sharedKoin_coreLevel *)level __attribute__((swift_name("init(level:)"))) __attribute__((objc_designated_initializer));
- (void)debugMsg:(NSString *)msg __attribute__((swift_name("debug(msg:)")));
- (void)displayLevel:(Auth_sharedKoin_coreLevel *)level msg:(NSString *)msg __attribute__((swift_name("display(level:msg:)")));
- (void)errorMsg:(NSString *)msg __attribute__((swift_name("error(msg:)")));
- (void)infoMsg:(NSString *)msg __attribute__((swift_name("info(msg:)")));
- (BOOL)isAtLvl:(Auth_sharedKoin_coreLevel *)lvl __attribute__((swift_name("isAt(lvl:)")));
- (void)logLvl:(Auth_sharedKoin_coreLevel *)lvl msg:(NSString *(^)(void))msg __attribute__((swift_name("log(lvl:msg:)")));
- (void)logLvl:(Auth_sharedKoin_coreLevel *)lvl msg_:(NSString *)msg __attribute__((swift_name("log(lvl:msg_:)")));
- (void)warnMsg:(NSString *)msg __attribute__((swift_name("warn(msg:)")));
@property Auth_sharedKoin_coreLevel *level __attribute__((swift_name("level")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreBeanDefinition")))
@interface Auth_sharedKoin_coreBeanDefinition<T> : Auth_sharedBase
- (instancetype)initWithScopeQualifier:(id<Auth_sharedKoin_coreQualifier>)scopeQualifier primaryType:(id<Auth_sharedKotlinKClass>)primaryType qualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier definition:(T _Nullable (^)(Auth_sharedKoin_coreScope *, Auth_sharedKoin_coreParametersHolder *))definition kind:(Auth_sharedKoin_coreKind *)kind secondaryTypes:(NSArray<id<Auth_sharedKotlinKClass>> *)secondaryTypes __attribute__((swift_name("init(scopeQualifier:primaryType:qualifier:definition:kind:secondaryTypes:)"))) __attribute__((objc_designated_initializer));
- (Auth_sharedKoin_coreBeanDefinition<T> *)doCopyScopeQualifier:(id<Auth_sharedKoin_coreQualifier>)scopeQualifier primaryType:(id<Auth_sharedKotlinKClass>)primaryType qualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier definition:(T _Nullable (^)(Auth_sharedKoin_coreScope *, Auth_sharedKoin_coreParametersHolder *))definition kind:(Auth_sharedKoin_coreKind *)kind secondaryTypes:(NSArray<id<Auth_sharedKotlinKClass>> *)secondaryTypes __attribute__((swift_name("doCopy(scopeQualifier:primaryType:qualifier:definition:kind:secondaryTypes:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (BOOL)hasTypeClazz:(id<Auth_sharedKotlinKClass>)clazz __attribute__((swift_name("hasType(clazz:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (BOOL)isClazz:(id<Auth_sharedKotlinKClass>)clazz qualifier:(id<Auth_sharedKoin_coreQualifier> _Nullable)qualifier scopeDefinition:(id<Auth_sharedKoin_coreQualifier>)scopeDefinition __attribute__((swift_name("is(clazz:qualifier:scopeDefinition:)")));
- (NSString *)description __attribute__((swift_name("description()")));
@property Auth_sharedKoin_coreCallbacks<T> *callbacks __attribute__((swift_name("callbacks")));
@property (readonly) T _Nullable (^definition)(Auth_sharedKoin_coreScope *, Auth_sharedKoin_coreParametersHolder *) __attribute__((swift_name("definition")));
@property (readonly) Auth_sharedKoin_coreKind *kind __attribute__((swift_name("kind")));
@property (readonly) id<Auth_sharedKotlinKClass> primaryType __attribute__((swift_name("primaryType")));
@property id<Auth_sharedKoin_coreQualifier> _Nullable qualifier __attribute__((swift_name("qualifier")));
@property (readonly) id<Auth_sharedKoin_coreQualifier> scopeQualifier __attribute__((swift_name("scopeQualifier")));
@property NSArray<id<Auth_sharedKotlinKClass>> *secondaryTypes __attribute__((swift_name("secondaryTypes")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreInstanceFactoryCompanion")))
@interface Auth_sharedKoin_coreInstanceFactoryCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedKoin_coreInstanceFactoryCompanion *shared __attribute__((swift_name("shared")));
@property (readonly) NSString *ERROR_SEPARATOR __attribute__((swift_name("ERROR_SEPARATOR")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreInstanceContext")))
@interface Auth_sharedKoin_coreInstanceContext : Auth_sharedBase
- (instancetype)initWithLogger:(Auth_sharedKoin_coreLogger *)logger scope:(Auth_sharedKoin_coreScope *)scope parameters:(Auth_sharedKoin_coreParametersHolder * _Nullable)parameters __attribute__((swift_name("init(logger:scope:parameters:)"))) __attribute__((objc_designated_initializer));
@property (readonly) Auth_sharedKoin_coreLogger *logger __attribute__((swift_name("logger")));
@property (readonly) Auth_sharedKoin_coreParametersHolder * _Nullable parameters __attribute__((swift_name("parameters")));
@property (readonly) Auth_sharedKoin_coreScope *scope __attribute__((swift_name("scope")));
@end

__attribute__((swift_name("KotlinCoroutineContextElement")))
@protocol Auth_sharedKotlinCoroutineContextElement <Auth_sharedKotlinCoroutineContext>
@required
@property (readonly) id<Auth_sharedKotlinCoroutineContextKey> key __attribute__((swift_name("key")));
@end

__attribute__((swift_name("KotlinCoroutineContextKey")))
@protocol Auth_sharedKotlinCoroutineContextKey
@required
@end

__attribute__((swift_name("Kotlinx_serialization_coreSerializersModule")))
@interface Auth_sharedKotlinx_serialization_coreSerializersModule : Auth_sharedBase

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)dumpToCollector:(id<Auth_sharedKotlinx_serialization_coreSerializersModuleCollector>)collector __attribute__((swift_name("dumpTo(collector:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<Auth_sharedKotlinx_serialization_coreKSerializer> _Nullable)getContextualKClass:(id<Auth_sharedKotlinKClass>)kClass typeArgumentsSerializers:(NSArray<id<Auth_sharedKotlinx_serialization_coreKSerializer>> *)typeArgumentsSerializers __attribute__((swift_name("getContextual(kClass:typeArgumentsSerializers:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<Auth_sharedKotlinx_serialization_coreSerializationStrategy> _Nullable)getPolymorphicBaseClass:(id<Auth_sharedKotlinKClass>)baseClass value:(id)value __attribute__((swift_name("getPolymorphic(baseClass:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy> _Nullable)getPolymorphicBaseClass:(id<Auth_sharedKotlinKClass>)baseClass serializedClassName:(NSString * _Nullable)serializedClassName __attribute__((swift_name("getPolymorphic(baseClass:serializedClassName:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJson.Default")))
@interface Auth_sharedKotlinx_serialization_jsonJsonDefault : Auth_sharedKotlinx_serialization_jsonJson
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)default_ __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedKotlinx_serialization_jsonJsonDefault *shared __attribute__((swift_name("shared")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Kotlinx_serialization_jsonJsonConfiguration")))
@interface Auth_sharedKotlinx_serialization_jsonJsonConfiguration : Auth_sharedBase
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) BOOL allowSpecialFloatingPointValues __attribute__((swift_name("allowSpecialFloatingPointValues")));
@property (readonly) BOOL allowStructuredMapKeys __attribute__((swift_name("allowStructuredMapKeys")));
@property (readonly) NSString *classDiscriminator __attribute__((swift_name("classDiscriminator")));
@property (readonly) BOOL coerceInputValues __attribute__((swift_name("coerceInputValues")));
@property (readonly) BOOL encodeDefaults __attribute__((swift_name("encodeDefaults")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) BOOL explicitNulls __attribute__((swift_name("explicitNulls")));
@property (readonly) BOOL ignoreUnknownKeys __attribute__((swift_name("ignoreUnknownKeys")));
@property (readonly) BOOL isLenient __attribute__((swift_name("isLenient")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) id<Auth_sharedKotlinx_serialization_jsonJsonNamingStrategy> _Nullable namingStrategy __attribute__((swift_name("namingStrategy")));
@property (readonly) BOOL prettyPrint __attribute__((swift_name("prettyPrint")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
@property (readonly) NSString *prettyPrintIndent __attribute__((swift_name("prettyPrintIndent")));
@property (readonly) BOOL useAlternativeNames __attribute__((swift_name("useAlternativeNames")));
@property (readonly) BOOL useArrayPolymorphism __attribute__((swift_name("useArrayPolymorphism")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Ktor_httpURLProtocol.Companion")))
@interface Auth_sharedKtor_httpURLProtocolCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedKtor_httpURLProtocolCompanion *shared __attribute__((swift_name("shared")));
- (Auth_sharedKtor_httpURLProtocol *)createOrDefaultName:(NSString *)name __attribute__((swift_name("createOrDefault(name:)")));
@property (readonly) Auth_sharedKtor_httpURLProtocol *HTTP __attribute__((swift_name("HTTP")));
@property (readonly) Auth_sharedKtor_httpURLProtocol *HTTPS __attribute__((swift_name("HTTPS")));
@property (readonly) Auth_sharedKtor_httpURLProtocol *SOCKS __attribute__((swift_name("SOCKS")));
@property (readonly) Auth_sharedKtor_httpURLProtocol *WS __attribute__((swift_name("WS")));
@property (readonly) Auth_sharedKtor_httpURLProtocol *WSS __attribute__((swift_name("WSS")));
@property (readonly) NSDictionary<NSString *, Auth_sharedKtor_httpURLProtocol *> *byName __attribute__((swift_name("byName")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeEncoder")))
@protocol Auth_sharedKotlinx_serialization_coreCompositeEncoder
@required
- (void)encodeBooleanElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(BOOL)value __attribute__((swift_name("encodeBooleanElement(descriptor:index:value:)")));
- (void)encodeByteElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int8_t)value __attribute__((swift_name("encodeByteElement(descriptor:index:value:)")));
- (void)encodeCharElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(unichar)value __attribute__((swift_name("encodeCharElement(descriptor:index:value:)")));
- (void)encodeDoubleElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(double)value __attribute__((swift_name("encodeDoubleElement(descriptor:index:value:)")));
- (void)encodeFloatElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(float)value __attribute__((swift_name("encodeFloatElement(descriptor:index:value:)")));
- (id<Auth_sharedKotlinx_serialization_coreEncoder>)encodeInlineElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("encodeInlineElement(descriptor:index:)")));
- (void)encodeIntElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int32_t)value __attribute__((swift_name("encodeIntElement(descriptor:index:value:)")));
- (void)encodeLongElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int64_t)value __attribute__((swift_name("encodeLongElement(descriptor:index:value:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (void)encodeNullableSerializableElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<Auth_sharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeNullableSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeSerializableElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index serializer:(id<Auth_sharedKotlinx_serialization_coreSerializationStrategy>)serializer value:(id _Nullable)value __attribute__((swift_name("encodeSerializableElement(descriptor:index:serializer:value:)")));
- (void)encodeShortElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(int16_t)value __attribute__((swift_name("encodeShortElement(descriptor:index:value:)")));
- (void)encodeStringElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index value:(NSString *)value __attribute__((swift_name("encodeStringElement(descriptor:index:value:)")));
- (void)endStructureDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)shouldEncodeElementDefaultDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("shouldEncodeElementDefault(descriptor:index:)")));
@property (readonly) Auth_sharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((swift_name("KotlinAnnotation")))
@protocol Auth_sharedKotlinAnnotation
@required
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerialKind")))
@interface Auth_sharedKotlinx_serialization_coreSerialKind : Auth_sharedBase
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@end

__attribute__((swift_name("Kotlinx_serialization_coreCompositeDecoder")))
@protocol Auth_sharedKotlinx_serialization_coreCompositeDecoder
@required
- (BOOL)decodeBooleanElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeBooleanElement(descriptor:index:)")));
- (int8_t)decodeByteElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeByteElement(descriptor:index:)")));
- (unichar)decodeCharElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeCharElement(descriptor:index:)")));
- (int32_t)decodeCollectionSizeDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeCollectionSize(descriptor:)")));
- (double)decodeDoubleElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeDoubleElement(descriptor:index:)")));
- (int32_t)decodeElementIndexDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("decodeElementIndex(descriptor:)")));
- (float)decodeFloatElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeFloatElement(descriptor:index:)")));
- (id<Auth_sharedKotlinx_serialization_coreDecoder>)decodeInlineElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeInlineElement(descriptor:index:)")));
- (int32_t)decodeIntElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeIntElement(descriptor:index:)")));
- (int64_t)decodeLongElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeLongElement(descriptor:index:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (id _Nullable)decodeNullableSerializableElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeNullableSerializableElement(descriptor:index:deserializer:previousValue:)")));

/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
- (BOOL)decodeSequentially __attribute__((swift_name("decodeSequentially()")));
- (id _Nullable)decodeSerializableElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index deserializer:(id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy>)deserializer previousValue:(id _Nullable)previousValue __attribute__((swift_name("decodeSerializableElement(descriptor:index:deserializer:previousValue:)")));
- (int16_t)decodeShortElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeShortElement(descriptor:index:)")));
- (NSString *)decodeStringElementDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor index:(int32_t)index __attribute__((swift_name("decodeStringElement(descriptor:index:)")));
- (void)endStructureDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor __attribute__((swift_name("endStructure(descriptor:)")));
@property (readonly) Auth_sharedKotlinx_serialization_coreSerializersModule *serializersModule __attribute__((swift_name("serializersModule")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("KotlinNothing")))
@interface Auth_sharedKotlinNothing : Auth_sharedBase
@end

__attribute__((swift_name("Koin_coreKoinComponent")))
@protocol Auth_sharedKoin_coreKoinComponent
@required
- (Auth_sharedKoin_coreKoin *)getKoin __attribute__((swift_name("getKoin()")));
@end

__attribute__((swift_name("Koin_coreKoinScopeComponent")))
@protocol Auth_sharedKoin_coreKoinScopeComponent <Auth_sharedKoin_coreKoinComponent>
@required
- (void)closeScope __attribute__((swift_name("closeScope()"))) __attribute__((deprecated("not used internaly anymore")));
@property (readonly) Auth_sharedKoin_coreScope *scope __attribute__((swift_name("scope")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreExtensionManager")))
@interface Auth_sharedKoin_coreExtensionManager : Auth_sharedBase
- (instancetype)initWith_koin:(Auth_sharedKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
- (void)close __attribute__((swift_name("close()")));
- (id<Auth_sharedKoin_coreKoinExtension>)getExtensionId:(NSString *)id __attribute__((swift_name("getExtension(id:)")));
- (id<Auth_sharedKoin_coreKoinExtension> _Nullable)getExtensionOrNullId:(NSString *)id __attribute__((swift_name("getExtensionOrNull(id:)")));
- (void)registerExtensionId:(NSString *)id extension:(id<Auth_sharedKoin_coreKoinExtension>)extension __attribute__((swift_name("registerExtension(id:extension:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreInstanceRegistry")))
@interface Auth_sharedKoin_coreInstanceRegistry : Auth_sharedBase
- (instancetype)initWith_koin:(Auth_sharedKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
- (void)saveMappingAllowOverride:(BOOL)allowOverride mapping:(NSString *)mapping factory:(Auth_sharedKoin_coreInstanceFactory<id> *)factory logWarning:(BOOL)logWarning __attribute__((swift_name("saveMapping(allowOverride:mapping:factory:logWarning:)")));
- (int32_t)size __attribute__((swift_name("size()")));
@property (readonly) Auth_sharedKoin_coreKoin *_koin __attribute__((swift_name("_koin")));
@property (readonly) NSDictionary<NSString *, Auth_sharedKoin_coreInstanceFactory<id> *> *instances __attribute__((swift_name("instances")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_corePropertyRegistry")))
@interface Auth_sharedKoin_corePropertyRegistry : Auth_sharedBase
- (instancetype)initWith_koin:(Auth_sharedKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
- (void)close __attribute__((swift_name("close()")));
- (void)deletePropertyKey:(NSString *)key __attribute__((swift_name("deleteProperty(key:)")));
- (id _Nullable)getPropertyKey:(NSString *)key __attribute__((swift_name("getProperty(key:)")));
- (void)savePropertiesProperties:(NSDictionary<NSString *, id> *)properties __attribute__((swift_name("saveProperties(properties:)")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScopeRegistry")))
@interface Auth_sharedKoin_coreScopeRegistry : Auth_sharedBase
- (instancetype)initWith_koin:(Auth_sharedKoin_coreKoin *)_koin __attribute__((swift_name("init(_koin:)"))) __attribute__((objc_designated_initializer));
@property (class, readonly, getter=companion) Auth_sharedKoin_coreScopeRegistryCompanion *companion __attribute__((swift_name("companion")));
- (void)loadScopesModules:(NSSet<Auth_sharedKoin_coreModule *> *)modules __attribute__((swift_name("loadScopes(modules:)")));
@property (readonly) Auth_sharedKoin_coreScope *rootScope __attribute__((swift_name("rootScope")));
@property (readonly) NSSet<id<Auth_sharedKoin_coreQualifier>> *scopeDefinitions __attribute__((swift_name("scopeDefinitions")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreLevel")))
@interface Auth_sharedKoin_coreLevel : Auth_sharedKotlinEnum<Auth_sharedKoin_coreLevel *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) Auth_sharedKoin_coreLevel *debug __attribute__((swift_name("debug")));
@property (class, readonly) Auth_sharedKoin_coreLevel *info __attribute__((swift_name("info")));
@property (class, readonly) Auth_sharedKoin_coreLevel *warning __attribute__((swift_name("warning")));
@property (class, readonly) Auth_sharedKoin_coreLevel *error __attribute__((swift_name("error")));
@property (class, readonly) Auth_sharedKoin_coreLevel *none __attribute__((swift_name("none")));
+ (Auth_sharedKotlinArray<Auth_sharedKoin_coreLevel *> *)values __attribute__((swift_name("values()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreKind")))
@interface Auth_sharedKoin_coreKind : Auth_sharedKotlinEnum<Auth_sharedKoin_coreKind *>
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
- (instancetype)initWithName:(NSString *)name ordinal:(int32_t)ordinal __attribute__((swift_name("init(name:ordinal:)"))) __attribute__((objc_designated_initializer)) __attribute__((unavailable));
@property (class, readonly) Auth_sharedKoin_coreKind *singleton __attribute__((swift_name("singleton")));
@property (class, readonly) Auth_sharedKoin_coreKind *factory __attribute__((swift_name("factory")));
@property (class, readonly) Auth_sharedKoin_coreKind *scoped __attribute__((swift_name("scoped")));
+ (Auth_sharedKotlinArray<Auth_sharedKoin_coreKind *> *)values __attribute__((swift_name("values()")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreCallbacks")))
@interface Auth_sharedKoin_coreCallbacks<T> : Auth_sharedBase
- (instancetype)initWithOnClose:(void (^ _Nullable)(T _Nullable))onClose __attribute__((swift_name("init(onClose:)"))) __attribute__((objc_designated_initializer));
- (Auth_sharedKoin_coreCallbacks<T> *)doCopyOnClose:(void (^ _Nullable)(T _Nullable))onClose __attribute__((swift_name("doCopy(onClose:)")));
- (BOOL)isEqual:(id _Nullable)other __attribute__((swift_name("isEqual(_:)")));
- (NSUInteger)hash __attribute__((swift_name("hash()")));
- (NSString *)description __attribute__((swift_name("description()")));
@property (readonly) void (^ _Nullable onClose)(T _Nullable) __attribute__((swift_name("onClose")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_coreSerializersModuleCollector")))
@protocol Auth_sharedKotlinx_serialization_coreSerializersModuleCollector
@required
- (void)contextualKClass:(id<Auth_sharedKotlinKClass>)kClass provider:(id<Auth_sharedKotlinx_serialization_coreKSerializer> (^)(NSArray<id<Auth_sharedKotlinx_serialization_coreKSerializer>> *))provider __attribute__((swift_name("contextual(kClass:provider:)")));
- (void)contextualKClass:(id<Auth_sharedKotlinKClass>)kClass serializer:(id<Auth_sharedKotlinx_serialization_coreKSerializer>)serializer __attribute__((swift_name("contextual(kClass:serializer:)")));
- (void)polymorphicBaseClass:(id<Auth_sharedKotlinKClass>)baseClass actualClass:(id<Auth_sharedKotlinKClass>)actualClass actualSerializer:(id<Auth_sharedKotlinx_serialization_coreKSerializer>)actualSerializer __attribute__((swift_name("polymorphic(baseClass:actualClass:actualSerializer:)")));
- (void)polymorphicDefaultBaseClass:(id<Auth_sharedKotlinKClass>)baseClass defaultDeserializerProvider:(id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefault(baseClass:defaultDeserializerProvider:)"))) __attribute__((deprecated("Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer")));
- (void)polymorphicDefaultDeserializerBaseClass:(id<Auth_sharedKotlinKClass>)baseClass defaultDeserializerProvider:(id<Auth_sharedKotlinx_serialization_coreDeserializationStrategy> _Nullable (^)(NSString * _Nullable))defaultDeserializerProvider __attribute__((swift_name("polymorphicDefaultDeserializer(baseClass:defaultDeserializerProvider:)")));
- (void)polymorphicDefaultSerializerBaseClass:(id<Auth_sharedKotlinKClass>)baseClass defaultSerializerProvider:(id<Auth_sharedKotlinx_serialization_coreSerializationStrategy> _Nullable (^)(id))defaultSerializerProvider __attribute__((swift_name("polymorphicDefaultSerializer(baseClass:defaultSerializerProvider:)")));
@end


/**
 * @note annotations
 *   kotlinx.serialization.ExperimentalSerializationApi
*/
__attribute__((swift_name("Kotlinx_serialization_jsonJsonNamingStrategy")))
@protocol Auth_sharedKotlinx_serialization_jsonJsonNamingStrategy
@required
- (NSString *)serialNameForJsonDescriptor:(id<Auth_sharedKotlinx_serialization_coreSerialDescriptor>)descriptor elementIndex:(int32_t)elementIndex serialName:(NSString *)serialName __attribute__((swift_name("serialNameForJson(descriptor:elementIndex:serialName:)")));
@end

__attribute__((swift_name("Koin_coreKoinExtension")))
@protocol Auth_sharedKoin_coreKoinExtension
@required
- (void)onClose __attribute__((swift_name("onClose()")));
@property Auth_sharedKoin_coreKoin *koin __attribute__((swift_name("koin")));
@end

__attribute__((objc_subclassing_restricted))
__attribute__((swift_name("Koin_coreScopeRegistry.Companion")))
@interface Auth_sharedKoin_coreScopeRegistryCompanion : Auth_sharedBase
+ (instancetype)alloc __attribute__((unavailable));
+ (instancetype)allocWithZone:(struct _NSZone *)zone __attribute__((unavailable));
+ (instancetype)companion __attribute__((swift_name("init()")));
@property (class, readonly, getter=shared) Auth_sharedKoin_coreScopeRegistryCompanion *shared __attribute__((swift_name("shared")));
@end

#pragma pop_macro("_Nullable_result")
#pragma clang diagnostic pop
NS_ASSUME_NONNULL_END
