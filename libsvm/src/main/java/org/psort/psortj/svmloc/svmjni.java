package org.psort.psortj.svmloc;

/**
 * Created with IntelliJ IDEA.
 * User: lairdm
 * Date: 13/09/13
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class svmjni {
    public svmjni () {
    }

    public static int getVal (int x) {
        return x;
    }

    public static int getVal2 (int x) {
        return x;
    }

    native public long createSVM(int st, int kt, int d, double g, double c0, double C, double nu, double e);

    native public void destroySVM(long svm);
    native public int loadSVMModel(long svm, String svm_file);
    native public int loadSVMFreqPattern(long svm, String fp_file);
    native public double SVMClassify(long svm, String seq);

}
