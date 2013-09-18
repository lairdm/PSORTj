package org.psort.psortj.hmmer;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: lairdm
 * Date: 17/09/13
 * Time: 2:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class hmmerjni {
    private long report_obj;

    public boolean hmmSearch(String filename, int df, int n2, String seq) {
                          // Check that the model file exists
        File f = new File(filename);
        if(!f.exists()) {
            return false;
        }

        report_obj = hmmsearch(filename, df, n2, seq);

        return (report_obj > 0 ? true : false);
    }

    public boolean hmmSearch(String filename, String seq) {
        return hmmSearch(filename, 0, 0, seq);
    }

    public int globalHitCount() {
        if(report_obj > 0) return 0;

        return countglobalhits(report_obj);
    }

    public int domainHitCount() {
        if(report_obj > 0) return 0;

        return countdomainhits(report_obj);
    }

    public float getGlobalScore(int hit) {
        if(report_obj > 0) return 0;

        if(hit > countglobalhits(report_obj)) return 0;

        return getindivglobalscore(report_obj, hit);
    }

    public float getDomainScore(int hit) {
        if(report_obj > 0) return 0;

        if(hit > countdomainhits(report_obj)) return 0;

        return getindivdomainscore(report_obj, hit);
    }

    public double getGlobalEValue(int hit) {
        if(report_obj > 0) return 0;

        if(hit > countglobalhits(report_obj)) return 0;

        return getindivglobalevalue(report_obj, hit);
    }

    public double getDomainEValue(int hit) {
        if(report_obj > 0) return 0;

        if(hit > countdomainhits(report_obj)) return 0;

        return getindivdomainevalue(report_obj, hit);
    }

    public double getGlobalPValue(int hit) {
        if(report_obj > 0) return 0;

        if(hit > countglobalhits(report_obj)) return 0;

        return getindivglobalpvalue(report_obj, hit);
    }

    public double getDomainPValue(int hit) {
        if(report_obj > 0) return 0;

        if(hit > countdomainhits(report_obj)) return 0;

        return getindivdomainpvalue(report_obj, hit);
    }


    public void destroyHMMER () {

        if(report_obj > 0 ? true : false) {
            destroyreport(report_obj);
        }
    }

    native public long hmmsearch(String filename, int df, int n2, String seq);
    native public void destroyreport(long report_obj);
    native public int countglobalhits(long report_obj);
    native public int countdomainhits(long report_obj);
    native public float getindivglobalscore(long report_obj, int hit);
    native public float getindivdomainscore(long report_obj, int hit);
    native public double getindivglobalpvalue(long report_obj, int hit);
    native public double getindivglobalevalue(long report_obj, int hit);
    native public double getindivdomainpvalue(long report_obj, int hit);
    native public double getindivdomainevalue(long report_obj, int hit);
}
