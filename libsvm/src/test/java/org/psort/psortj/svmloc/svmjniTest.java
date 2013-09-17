package org.psort.psortj.svmloc;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: lairdm
 * Date: 13/09/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class svmjniTest {

    @Test
    public void testGetVal() throws Exception {
        svmjni svmobj = new svmjni();
        Assert.assertEquals("Must be 5", 5, svmobj.getVal(5));
    }

    @Test
    public void testGetVal2() throws Exception {
        svmjni svmobj = new svmjni();
        Assert.assertEquals("Must be 5", 5, svmobj.getVal2(5));
    }

    @Test
    public void testcreateSVM() throws Exception {
        System.loadLibrary("svmloc");

        svmjni svmobj = new svmjni();

        long pSVM = svmobj.createSVM(0, 2, 3, 0, 0, 1, 0.5, 0.1);

    }

    @Test
    public void testSVMModel() throws Exception {
        System.loadLibrary("svmloc");

        svmjni svmobj = new svmjni();

        long pSVM = svmobj.createSVM(0, 2, 3, 0, 0, 1, 0.5, 0.1);

        int ret = svmobj.loadSVMModel(pSVM,"src/models/SVM_MODEL.txt");
        Assert.assertNotEquals("SVM Model loading must not equal 0", 0, ret);

        ret = svmobj.loadSVMFreqPattern(pSVM,"src/models/fre_patterns.txt");
        Assert.assertNotEquals("SVM freq patterns must not equal 0", 0, ret);

        double svm_ret = svmobj.SVMClassify(pSVM, "MRKRVSPEELVADIRQTADKLNQEYLTADEYDRRGEYNKSTPIDRFGSWNAAVRKAGLEVAHKAQRNSKETLLADLRRVADSLNQDHLTITEYEDKGNHGVATITRRLGSWNDALREAGLTPFQKKNIEPEDILRDLRRVADDTNGNSVIIPEYETHGDYGITTIAAKFGSWTNAVRKAGFTPATEITEEELLIDLRRIANETVGDTLLKSDYKEYGEYSPSTALRRFGTWDEVVEKVGATSGDQKIPDEDLFADLRRVADEIDRRCLTKADYDERGKYSASTITARFESWGSAVKEAGLLPVSQWYGTTEQPSWTQLGRSPNECKIAKEDLLIDLRRVANKIEGDRIKARDYDQEGKYSATTVIRQFESWVNAVEKVGYKSHIKRIATEDLKHSLQNVGSEDEVPTSTEYAENGKYHYQTVIERFGSWSNAVQAAGYTSYSPPRTSWIPSEELIASIQTLSSEDEPPTSIEYDESGKFGTATVVRRFGTWANALQEAGYTSKQIDRLLPYTDDVEDEELLRELRRLADGEVGPTTHTIKTEGDYSTTPYFDRFGTIWQSVVCAGLKPYSRTPVTKTQYVDFIETVLDYGHPTRQLTGLLLAFTGLETTLTGKFSTEWVVNLNTSEETAIRVPKEHLQSDEDWILKVPSKWHNPETNQQETTHIEGLLNWAVNHEQELYSSTSGVESFLSMVNESIGIEGSRESHLTMALGTHLAERGAPPWFIQKQTGVGFRGMDAEVEDFYLWNYVHQGINHPDYNPPDVVLNPTGRIID");
        Assert.assertEquals(0, svm_ret, 1e-15);

        svm_ret = svmobj.SVMClassify(pSVM, "AAAAAAAA");
        Assert.assertEquals(10, svm_ret, 1e-15);

    }
}
