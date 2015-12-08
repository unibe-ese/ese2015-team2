package ch.eset2.web.util;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * Holds Navigation Cases
 * 
 * @author Marc Jost
 * @version 1.0
 */

@Named
@ApplicationScoped
public class Navigation {
    public static final String ABOUT = "about.xhtml";
    public static final String INDEX = "index.xhtml";
    public static final String INBOX = "viewinbox.xhtml";
    public static final String FAQ = "faq.xhtml";
    public static final String AGB = "agb.xhtml";
    public static final String REGISTRATION = "registration.xhtml";
    public static final String REGSUCCESS = "regsuccess.xhtml";
    public static final String EDITPROFILE = "editprofile.xhtml";
    public static final String VIEWPROFILE = "viewprofile.xhtml";
    public static final String SENDSUCCESS = "sendsuccess.xhtml";
    public static final String SEARCHTUTOR = "searchtutors.xhtml";
    public static final String CONTACT = "contact.xhtml";
    public static final String CONTACTFORMSUCCESS="contactformsuccess.xhtml";
    public static final String ACCEPTSUCCESS = "acceptsuccess.xhtml";
    public static final String OFFERFAILED = "offerfailed.xhtml";
    public static final String VIEWCOURSES = "viewcourses.xhtml";
    public static final String VIEWCOURSE = "viewcourse.xhtml";
    public static final String VIEWMESSAGE = "viewmessage.xhtml";
    public static final String VIEWOFFER = "viewoffer.xhtml";
    public static final String CREATEOFFER = "createoffer.xhtml";

    // Getters for direct access from .xhtml pages. Accessing public fields won't work.
    public String getINDEX() {
        return INDEX;
    }

    public String getINBOX() {
        return INBOX;
    }

    public String getREGISTRATION() {
        return REGISTRATION;
    }

    public String getREGSUCCESS() {
        return REGSUCCESS;
    }

    public String getEDITPROFILE() {
        return EDITPROFILE;
    }

    public String getVIEWPROFILE() {
        return VIEWPROFILE;
    }

    public String getSENDSUCCESS() {
        return SENDSUCCESS;
    }

    public String getSEARCHTUTOR() {
        return SEARCHTUTOR;
    }
    
    public String getCONTACT() {
        return CONTACT;
    }

    public String getCONTACTFORMSUCCESS() {
        return CONTACTFORMSUCCESS;
    }

    public String getACCEPTSUCCESS() {
        return ACCEPTSUCCESS;
    }

    public String getOFFERFAILED() {
        return OFFERFAILED;
    }

    public String getVIEWCOURSES() {
        return VIEWCOURSES;
    }
    
    public String getVIEWCOURSE() {
        return VIEWCOURSE;
    }
    
    public String getVIEWMESSAGE() {
        return VIEWMESSAGE;
    }
    
    public String getVIEWOFFER() {
        return VIEWOFFER;
    }
    
    public String getCREATEOFFER() {
        return CREATEOFFER;
    }
    
    public String getFAQ() {
        return FAQ;
    }
    
    public String getAGB() {
        return AGB;
    }
    
    public String getABOUT() {
        return ABOUT;
    }
}

