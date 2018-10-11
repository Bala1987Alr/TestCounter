#include <jni.h>
#include <string>

extern "C" JNIEXPORT jint JNICALL
Java_com_example_balasubramanianmurge_testcounter_MainActivity_countFromJNI(
        JNIEnv *env,
        jobject, jint count_form_java)
{
    return count_form_java+1;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_balasubramanianmurge_testcounter_MainActivity_staticcountFromJNI(
        JNIEnv *env,
jobject)
{
    static int count;
    count=count+1;
    return count;
}


