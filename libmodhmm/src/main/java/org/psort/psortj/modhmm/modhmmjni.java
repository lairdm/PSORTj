package org.psort.psortj.modhmm;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: lairdm
 * Date: 16/09/13
 * Time: 9:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class modhmmjni {

    private long Helices_obj;
    private int hCount;

    private static int HMMFILEERROR = -10;
    private static int REPFILEERROR = -11;


    public boolean getHelices (String seq, String hmmfilename, String repfilename, String path) {
        // First let's check if the hmm file and rep file exist
        File f = new File(hmmfilename);
        if(!f.exists()) {
            hCount = HMMFILEERROR;
            System.err.println("Error, hmmfile doesn't exist");
            return false;
        }
        f = new File(repfilename);
        if(!f.exists()) {
            hCount = REPFILEERROR;
            System.err.println("Error, repfile doesn't exist");
            return false;
        }

        // Next we need to replace the character modhmm doesn't like in sequences
        seq.replaceAll("O", "X").replaceAll("-", "X").replaceAll(".", "X").replaceAll("\\*", "X")
                .replaceAll("\\?", "X").replaceAll("~", "X");

        // Call the library to calculate the helices
        Helices_obj = gethelices(seq, hmmfilename, repfilename, path);

        // Let's save the count for later and therefore preserve errors too
        hCount = helixcount(Helices_obj);

        if(hCount < 0) {
            return false;
          }

          return true;
      }

    public int helixCount() {
        return helixcount(Helices_obj);

    }

    public int helixStart(int helix) {
        return helixstart(Helices_obj, helix);
    }

    public int helixEnd(int helix) {
        return helixend(Helices_obj, helix);
    }

    public void helixDestroy() {
        helixdestroy(Helices_obj);
    }

    native public long gethelices(String seq, String hmmfilename, String repfilename, String path);

    native public int helixcount(long h_obj);
    native public int helixstart(long h_obj, int helix);
    native public int helixend(long h_obj, int helix);
    native public void helixdestroy(long h_obj);
}
