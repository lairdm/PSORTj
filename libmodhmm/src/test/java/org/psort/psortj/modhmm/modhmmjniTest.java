package org.psort.psortj.modhmm;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: lairdm
 * Date: 16/09/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class modhmmjniTest {
    private String seqstr =  new String("MMSSPHPMSSSRNTPLGVFYSLLACFYWGMVFVIPSMLGNFADLDIVLTRYSVFGICSLITILYKRSNIFKTVPFFLWKKGILWAFLINIAYYFGIAQAVRYSGSAVTVIIAGLAPIAILFYSNIKKKMLSYSFLLSMSGIIVVGIILSNVSEFQSESSSSLPLYLLGLGCVTAATSIWAGYIICNHDFLEQHSEISPDTWCHMLGISSLIICLPLIILGDTFGITHVTRNFLFHTPLSERCLFIVLCSAMGIFSSSRAIAAWNKASLHLSTALLGALLIFEPIFGWILSYLCKREMPSFQEGLGFFLMLGASLCLLLAQKKASEQETPSETLITTESDANJ");
    private String hmmfile = new String("src/HMMS/S_TMHMM_0.92b.hmg");
    private String repfile = new String("src/HMMS/replacement_letter_multi.rpl");
    private String path = new String("src/HMMS/");

    @Test
    public void testGetHelices() throws Exception {

        // Load the dynamic library
        System.loadLibrary("modhmm");

        // Make the object for the jni binding calls
        modhmmjni modhmmobj = new modhmmjni();

        // Let's see if we can predict alpha helices
        boolean ret = modhmmobj.getHelices(seqstr, hmmfile, repfile, path);

        // Did it come back true for the *ability* to predict?
        // (we'll check the results of how many were predicted later)
        Assert.assertEquals(true, ret);

        // Free the memory associated with the prediction
        modhmmobj.helixDestroy();
    }

    @Test
    public void testHelix_count() throws Exception {
        System.loadLibrary("modhmm");

        // Make the object for the jni binding calls
        modhmmjni modhmmobj = new modhmmjni();

        // Let's see if we can predict alpha helices
        boolean ret = modhmmobj.getHelices(seqstr, hmmfile, repfile, path);


        // Find the count of helices
        int count = modhmmobj.helixCount();

        // Assert we have 10 helices found
        Assert.assertEquals("We should find 10 helices", 10, count);

        // Free the memory associated with the prediction
        modhmmobj.helixDestroy();
    }

    @Test
    public void testHelix_start() throws Exception {
        System.loadLibrary("modhmm");

        // Make the object for the jni binding calls
        modhmmjni modhmmobj = new modhmmjni();

        // Let's see if we can predict alpha helices
        boolean ret = modhmmobj.getHelices(seqstr, hmmfile, repfile, path);


        // Find the count of helices
        int start = modhmmobj.helixStart(2);

        // Assert we have 10 helices found
        Assert.assertEquals("The second helix should start at bp 44", 44, start);

        // Free the memory associated with the prediction
        modhmmobj.helixDestroy();

    }

    @Test
    public void testHelix_end() throws Exception {
        System.loadLibrary("modhmm");

        // Make the object for the jni binding calls
        modhmmjni modhmmobj = new modhmmjni();

        // Let's see if we can predict alpha helices
        boolean ret = modhmmobj.getHelices(seqstr, hmmfile, repfile, path);


        // Find the count of helices
        int end = modhmmobj.helixStart(4);

        // Assert we have 10 helices found
        Assert.assertEquals("The forth helix should end at bp 103", 103, end);

        // Free the memory associated with the prediction
        modhmmobj.helixDestroy();

    }
}
