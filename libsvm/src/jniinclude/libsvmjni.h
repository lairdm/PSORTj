/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_psort_psortj_svmloc_svmjni */

#ifndef _Included_org_psort_psortj_svmloc_svmjni
#define _Included_org_psort_psortj_svmloc_svmjni
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_psort_psortj_svmloc_svmjni
 * Method:    createSVM
 * Signature: (IIIDDDDD)J
 */
JNIEXPORT jlong JNICALL Java_org_psort_psortj_svmloc_svmjni_createSVM
  (JNIEnv *, jobject, jint, jint, jint, jdouble, jdouble, jdouble, jdouble, jdouble);

/*
 * Class:     org_psort_psortj_svmloc_svmjni
 * Method:    destroySVM
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_psort_psortj_svmloc_svmjni_destroySVM
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_psort_psortj_svmloc_svmjni
 * Method:    loadSVMModel
 * Signature: (JLjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_psort_psortj_svmloc_svmjni_loadSVMModel
  (JNIEnv *, jobject, jlong, jstring);

/*
 * Class:     org_psort_psortj_svmloc_svmjni
 * Method:    loadSVMFreqPattern
 * Signature: (JLjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_org_psort_psortj_svmloc_svmjni_loadSVMFreqPattern
  (JNIEnv *, jobject, jlong, jstring);

/*
 * Class:     org_psort_psortj_svmloc_svmjni
 * Method:    SVMClassify
 * Signature: (JLjava/lang/String;)D
 */
JNIEXPORT jdouble JNICALL Java_org_psort_psortj_svmloc_svmjni_SVMClassify
  (JNIEnv *, jobject, jlong, jstring);

#ifdef __cplusplus
}
#endif
#endif
