package ch.eset2.testing;

import ch.eset2.model.Course;
import ch.eset2.model.dao.CourseFacade;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Simple Class to create some initial Data in the database
 *
 * @author Marc Jost
 * @version 1.0
 */
@Singleton
@Startup
public class DevelopmentDataCourses {

    @Inject
    private CourseFacade courseFacade;

    public DevelopmentDataCourses() {

    }

    @PostConstruct
    public void initializeTestData() {
        createTestCourses();
    }

    private void createTestCourses() {
        try {
            Course ese = new Course();
            ese.setTitle("Einführung in Software Engineering");
            ese.setDescription("This course is intended for Bachelors students in the third semester studying a major or minor in Computer Science. The goal of this course is to provide an introduction to the key concepts of Software Engineering.");
            ese.setECTS("5");
            ese.setSemester("Herbst");
            ese.setLevel("Bachelor");
            courseFacade.create(ese);

            Course ei = new Course();
            ei.setTitle("Einführung in die Informatik");
            ei.setDescription("Das Ziel dieser Veranstaltung ist, eine Übersicht über die wichtigsten Themen und Grundbegriffe der Informatik zu vermitteln. ");
            ei.setECTS("5");
            ei.setSemester("Herbst");
            ei.setLevel("Bachelor");
            courseFacade.create(ei);
            
            Course cg = new Course();
            cg.setTitle("Computergrafik");
            cg.setDescription("Diese Vorlesung bietet eine Einführung in die 3D Computergrafik. Der Stoff umfasst die Grundlagen der 3D Bildgenerierung und Modellierung, wobei der Schwerpunkt auf interaktiven Anwendungen liegt. Wir behandeln unter anderem die Repräsentation von 3D Geometrie, 3D Transformationen, Projektionen, Rasterisierung, Grundlagen zur Texturierung und zu Beleuchtungsmodellen, sowie die Programmierung moderner Graphics Processing Units (GPUs). Die Übungen zur Vorlesung vertiefen den Stoff mit Programmierprojekten basierend auf Java und OpenGL.");
            cg.setECTS("5");
            cg.setSemester("Herbst");
            cg.setLevel("Bachelor");
            courseFacade.create(cg);
            
            Course cn = new Course();
            cn.setTitle("Computernetze");
            cn.setDescription("Die Vorlesung gibt eine Einführung in die Architektur von Kommunikationsprotokollen, wie sie vor allem im Internet und in Telekommunikationsnetzen eingesetzt werden. Im Mittelpunkt der Vorlesung stehen Protokolle, z.B. TCP/IP, die im Internet eingesetzt werden. Die Vorlesung deckt auch Hardware-nahe sowie Awendungsaspekte ab.");
            cn.setECTS("5");
            cn.setSemester("Herbst");
            cn.setLevel("Bachelor");
            courseFacade.create(cn);
            
            Course dml = new Course();
            dml.setTitle("Diskrete Mathematik und Logik");
            dml.setDescription("Diese Veranstaltung führt Sie in diskrete Mathematik und Logik ein und stellt eine Reihe von zentralen Methoden und Konzepten vor. Sie sollen unter anderem auch Erfahrung sammeln, mit diesen Begriffen und Techniken in einem informatischen Kontext (mathematisch) präzise umzugehen.");
            dml.setECTS("5");
            dml.setSemester("Herbst");
            dml.setLevel("Bachelor");
            courseFacade.create(dml);
            
            Course gti = new Course();
            gti.setTitle("Grundlagen der technischen Informatik");
            gti.setDescription("Inhalte dieses Kurses sind:Boolsche Algebra, Logische Schaltungen (inkl. Multiplexer, Addierer, Multiplizierer, ALU), Vereinfachen und Testen von logischen Schaltungen, Flip-Flops und Schaltungen mit Delays, Programmierbare Logikmodule");
            gti.setECTS("5");
            gti.setSemester("Herbst");
            gti.setLevel("Bachelor");
            courseFacade.create(gti);
            
            Course ml = new Course();
            ml.setTitle("Maschinelles Lernen");
            ml.setDescription("Ehemals künstliche Intelligenz.");
            ml.setECTS("5");
            ml.setSemester("Herbst");
            ml.setLevel("Bachelor");
            courseFacade.create(ml);
            
            Course mms = new Course();
            mms.setTitle("Mensch-Maschine:Schnittstelle");
            mms.setDescription("In dieser Vorlesung wird eine allgemeine Einführung in das Gebiet der Human-Computer-Interaction gegeben. Im Vordergrund stehen Modelle und Methoden zur benutzergerechten Gestaltung von interaktiven Systemen, wobei auch einfache psychologische und kognitionswissenschaftliche Aspekte besprochen werden sollen. Diese Vorlesung benötigt keine besonderen Vorkenntnisse und setzt keine anderen Vorlesungen voraus; sie kann deshalb zu einem beliebigen Zeitpunkt im Bachelorstudium (Haupt- oder Nebenfach Informatik) besucht werden. ");
            mms.setECTS("5");
            mms.setSemester("Herbst");
            mms.setLevel("Bachelor");
            courseFacade.create(mms);
            
            Course p1 = new Course();
            p1.setTitle("Programmierung 1");
            p1.setDescription("In dieser Vorlesung wird eine Einführung in die Programmierung anhand der Sprache Java gegeben. Die Grundprinzipien der objektorientierten Programmierung (Objekte, Klassen, Nutzung, Vererbung) werden vorgestellt und eingeübt. Für die praktische Arbeit stehen LINUX-Rechner zu Verfügung. ");
            p1.setECTS("5");
            p1.setSemester("Herbst");
            p1.setLevel("Bachelor");
            courseFacade.create(p1);
            
            Course afs = new Course();
            afs.setTitle("Automaten und formale Sprache");
            afs.setDescription("Automatentheorie (endliche Automaten, Kellerautomaten, Turingmaschinen). Reguläre Ausdrücke. Chomsky-Hierarchie und Grammatiken.");
            afs.setECTS("5");
            afs.setSemester("Frühling");
            afs.setLevel("Bachelor");
            courseFacade.create(afs);
            
            Course bk = new Course();
            bk.setTitle("Berechenbarkeit und Komplexität");
            bk.setDescription("Im Zentrum des ersten Teils der Vorlesung stehen verschiedene Formalisierungen des intuitiven Algorithmusbegriffs und die These von Church. Die Konzepte der algorithmischen Entscheidbarkeit und Semi-Entscheidbarkeit sowie die Grenzen der theoretischen Berechenbarkeit werden eingehend untersucht. Im zweiten Teil der Vorlesung wird eine kurze Einführung in die Komplexitätstheorie gegeben; dabei werden die Grenzen der praktischen Berechenbarkeit besprochen. Im Vordergrund stehen die Klassen P und NP, die Theorie der NP-Vollständigkeit und die P != NP Vermutung.");
            bk.setECTS("5");
            bk.setSemester("Frühling");
            bk.setLevel("Bachelor");
            courseFacade.create(bk);
            
            Course bs = new Course();
            bs.setTitle("Betriebssysteme");
            bs.setDescription("Inhalt \n" +
                "1. Entwicklung und Typen \n" +
                "2. Aufgaben und Strukturen \n" +
                "3. Prozesse und Threads \n" +
                "4. Scheduling von Prozessen \n" +
                "5. Kommunikation und Synchronisation zwischen Prozessen \n" +
                "6. Verklemmung von Prozessen \n" +
                "7. Hauptspeicherverwaltung \n" +
                "8. Virtueller Speicher \n" +
                "9. Massenspeicher \n" +
                "10. Dateisysteme \n" +
                "11. Ein-/Ausgabe \n" +
                "12. Verteilte Dateisysteme \n" +
                "13. Sicherheit \n" +
                "14. Zusammenfassung");
            bs.setECTS("5");
            bs.setSemester("Frühling");
            bs.setLevel("Bachelor");
            courseFacade.create(bs);
            
            Course db = new Course();
            db.setTitle("Datenbanken");
            db.setDescription("Diese Vorlesung bietet eine umfassende Einführung in die Theorie und Praxis relationaler Datenbanken. Sie beginnt mit einer mathematisch präzisen Darstellung des relationalen Models und der relationalen Algebra. Darauf basierend wird die Datenbanksprache SQL vorgestellt und anhand zahlreicher praktischer Beispiele besprochen. Weiter werden die grundlegenden Prinzipien des Schemaentwurfs sowie Normalformen vermittelt. Wir behandeln auch weiterführende Themen, wie logische und physische Query-Optimierung oder Transaktionsverarbeitung.");
            db.setECTS("5");
            db.setSemester("Frühling");
            db.setLevel("Bachelor");
            courseFacade.create(db);
            
            Course da = new Course();
            da.setTitle("Datenstrukturen und Algorithmen");
            da.setDescription("Datenstrukturen und Algorithmen bilden die Grundbausteine aus denen Computerprogramme aufgebaut sind. In dieser Vorlesung stellen wir einige der wichtigsten Algorithmen vor, die als universelle Bausteine zahllose Anwendungen in grösseren Systemen haben. Dazu gehören Algorithmen zum Sortieren und Suchen von Daten, sowie Algorithmen um Optimierungs- und Graphenprobleme zu lösen. Wir behandeln weiter grundlegende Strategien zum Entwurf und zur Analyse von Algorithmen. Bei der Analyse interessiert uns vor allem die Frage der Effizienz von Algorithmen, welche für die praktische Anwendung oft entscheidend ist. Viele Vorlesungen innerhalb des Informatikstudiums greifen auf das in dieser Veranstaltung vermittelte Basiswissen zurück, und Kenntnisse des Stoffs können bei der Lösung vieler praktischer Programmierprobleme von grossem Nutzen sein.");
            da.setECTS("5");
            da.setSemester("Frühling");
            da.setLevel("Bachelor");
            courseFacade.create(da);
            
            Course pse = new Course();
            pse.setTitle("Praktikum Software Engineering");
            pse.setDescription("Im Praktikum Software Engineering erstellen die Studierenden Software Projekte für externe Kunden.");
            pse.setECTS("5");
            pse.setSemester("Frühling");
            pse.setLevel("Bachelor");
            courseFacade.create(pse);
            
            Course p2 = new Course();
            p2.setTitle("Programmierung 2");
            p2.setDescription("This course provides an introduction to object-oriented design, with emphasis on the following themes: How does Responsibility-Driven Design help you to decompose a complex system into objects? How does Design by Contract help you to develop robust software? How do you make use of inheritance to design flexible and generic software systems? How do iterative and incremental development and continuous refactoring help you to arrive at a clean and understandable design? How do you effectively test software? How do you avoid developing complex and unmaintainable code by consistently applying simple design principles? What kinds of known design patterns help you to simplify your software? How do you develop software that communicates its own design? How do you effectively use tools like debuggers, version control systems, and integrated development environments?");
            p2.setECTS("5");
            p2.setSemester("Frühling");
            p2.setLevel("Bachelor");
            courseFacade.create(p2);
            
            Course ra = new Course();
            ra.setTitle("Rechnerarchitektur");
            ra.setDescription("In computer science there are many applications, such as computer simulations, financial transactions and medical telesurgery, where performance is of paramount importance. To write successful programs for such applications, a programmer needs to understand what factors affect performance. This course shows a deep analysis of these factors and how they depend on how both hardware and software are combined in the context of computer organization and design. The course provides a brief introduction to C programming language and then proceeds with the MIPS assembly language, the analysis of computer performance, the description of the computer architecture and advanced technics to gain performance such as pipelining, dealing with hazards, memory architectures, and I/O systems.");
            ra.setECTS("5");
            ra.setSemester("Frühling");
            ra.setLevel("Bachelor");
            courseFacade.create(ra);
            //Masterleistung im Bachelor
            /*
            Course bt = new Course();
            bt.setTitle("Beweistheorie");
            bt.setDescription("Proof theory is one of the four central pillars of mathematical logic, dealing with formal proofs, studying their properties and developing techniques for their representation and simplification. Proof theory and proof-theoretic techniques have important applications in computer science such as, for example, automated theorem proving, artificial intelligence, logical data bases and expert systems, formal verification. In this course we begin with classical first order logic the central and basic area for all sorts of reasoning, introduce the most important framework for formal proofs, and present the central normalization technique. Then we turn to the constructive variant of classical logic and end with the famous “proofs as computations” approach.");
            bt.setECTS("5");
            bt.setSemester("Herbst");
            bt.setLevel("Masterleistung im Bachelor");
            courseFacade.create(ra);
            
            Course cv = new Course();
            cv.setTitle("Computer Vision");
            cv.setDescription("This course covers fundamental topics in computer vision. The course will provide an introduction to image formation, image processing, feature detection, segmentation, multiple view geometry and 3D reconstruction, motion, object recognition and classification.");
            cv.setECTS("5");
            cv.setSemester("Herbst");
            cv.setLevel("Masterleistung im Bachelor");
            courseFacade.create(cv);
            
            Course smdp = new Course();
            smdp.setTitle("Concurrency: State Models and Design Patterns");
            smdp.setDescription("Concurrency: State Models and Design Patterns");
            smdp.setECTS("5");
            smdp.setSemester("Herbst");
            smdp.setLevel("Masterleistung im Bachelor");
            courseFacade.create(smdp);
            
            Course mol = new Course();
            mol.setTitle("Modallogik");
            mol.setDescription("Modal logic originated in the domain of Philosophy, but during the past decades became a vibrant area with fundamental applications in computer science, AI, mathematics, epistemology, etc. This course offers a systematic exposition of fundamentals of modal logic and its applications.");
            mol.setECTS("5");
            mol.setSemester("Herbst");
            mol.setLevel("Masterleistung im Bachelor");
            courseFacade.create(mol);
            
            Course sal = new Course();
            sal.setTitle("Seminar:Algebra and Logic ");
            sal.setDescription("In this seminar, we will consider the games people play (e.g., Chess, Go, Poker, Jass) and the puzzles they solve (e.g., sliding blocks) from the perspective of computational complexity. We investigate the underlying mathematical reasons why certain games and puzzles are challenging, and find also that games and puzzles serve as powerful alternative models of computation. The relationships between games, puzzles, and computation are studied in the framework of constraint logic. We will see that a constraint logic both represents the computationally hardest case from a family of games or puzzles (one or two player, perfect or imperfect information, etc.), and determines a corresponding complexity class (P, NP, PSPACE, EXPTIME, etc.).");
            sal.setECTS("5");
            sal.setSemester("Herbst");
            sal.setLevel("Masterleistung im Bachelor");
            courseFacade.create(sal);
            
            Course scg = new Course();
            scg.setTitle("Seminar: Computer Graphics");
            scg.setDescription("The goal of the computer graphics seminar is to introduce students to current research in computer graphics. Topics vary each semester, and range from 3D rendering, modeling, and animation, to image processing and computational photography. The seminar includes lectures by the instructor and external guests to introduce selected topics. In addition, we will read and discuss recent research papers. The seminar also provides the opportunity for students pursuing Bachelors and Masters projects to present their work.");
            scg.setECTS("5");
            scg.setSemester("Herbst");
            scg.setLevel("Masterleistung im Bachelor");
            courseFacade.create(scg);
            
            Course scv = new Course();
            scv.setTitle("Seminar: Computer Vision");
            scv.setDescription("This course will cover the basics on soft skills such as: critical analysis, scientific writing, presenting, peer reviewing, team work and program management. The course will use publications in computer vision and machine learning as examples to illustrate and practice each soft skill. Most of the work will be done and evaluated in class. Some sessions may be substituted by seminars.");
            scv.setECTS("5");
            scv.setSemester("Herbst");
            scv.setLevel("Masterleistung im Bachelor");
            courseFacade.create(scv);
            
            Course ssc = new Course();
            ssc.setTitle("Seminar: Software Composition");
            ssc.setDescription("Seminar: Software Composition");
            ssc.setECTS("5");
            ssc.setSemester("Herbst");
            ssc.setLevel("Masterleistung im Bachelor");
            courseFacade.create(ssc);
            
            Course snit = new Course();
            snit.setTitle("Sensor Networks and Internet of Things");
            snit.setDescription("Sensor Networks and Internet of Things");
            snit.setECTS("5");
            snit.setSemester("Herbst");
            snit.setLevel("Masterleistung im Bachelor");
            courseFacade.create(snit);
            
            Course gp = new Course();
            gp.setTitle("3D Geometry Processing");
            gp.setDescription("3D geometry processing is the technology to represent and process, and edit virtual 3D objects. It has applications in 3D computer graphics content production, computer aided design and manufacturing, 3D printing, or computer simulation. This class gives an introduction to algorithms and data structures for 3D geometry processing, including 3D geometry representations, surface reconstruction from scanned 3D data, algorithms for 3D surface processing such as smoothing and parameterization, and algorithms for interactive 3D object editing. The class also discusses applications such as 3D printing and computer simulation. In practical projects students will develop a complete software pipeline for a \"3D fax machine\" to scan, process, and make physical copies of 3D objects.");
            gp.setECTS("5");
            gp.setSemester("Herbst");
            gp.setLevel("Masterleistung im Bachelor");
            courseFacade.create(gp);
            
            Course ct = new Course();
            ct.setTitle("Computability Theory");
            ct.setDescription("Computability Theory");
            ct.setECTS("5");
            ct.setSemester("Frühling");
            ct.setLevel("Masterleistung im Bachelor");
            courseFacade.create(ct);
            
            Course mc = new Course();
            mc.setTitle("Mobile Communications");
            mc.setDescription("Mobile Communications");
            mc.setECTS("5");
            mc.setSemester("Frühling");
            mc.setLevel("Masterleistung im Bachelor");
            courseFacade.create(mc);
            
            Course ps = new Course();
            ps.setTitle("Programmiersprachen");
            ps.setDescription("In this course we adopt the viewpoint that programming is modeling, so different programming languages offer us different ways to model our applications. We will examine a number of different paradigms for programming, and in each case look at one or more concrete examples of programming languages that support that paradigm. Specifically we will look at languages like Postscript, Haskell, Prolog, JavaScript and EToys. We will also take a brief look at the semantics of programming languages, and we will see how semantic descriptions can be made directly executable to obtain a rapid prototype of a language.");
            ps.setECTS("5");
            ps.setSemester("Frühling");
            ps.setLevel("Masterleistung im Bachelor");
            courseFacade.create(ps);
            
            Course rea = new Course();
            rea.setTitle("Rendering Algorithms");
            rea.setDescription("This course provides an introduction to realistic 3D rendering in computer graphics. You will learn about the theory and practice of designing 3D rendering programs to generate realistic images. We will cover the background of phyiscally based image synthesis including bidirectional reflectance distribution functions and the rendering equation. We will discuss algorithms to compute the rendering equation such as Monte Carlo path tracing, photon mapping, and radiosity. You will learn about strategies for efficient ray tracing, high-quality antialiasing, and more. The course includes several programming assignments where you will implement a 3D rendering program based on ray tracing step by step.");
            rea.setECTS("5");
            rea.setSemester("Frühling");
            rea.setLevel("Masterleistung im Bachelor");
            courseFacade.create(rea);
            
            Course sall = new Course();
            sall.setTitle("Seminar: Algebra and Logic");
            sall.setDescription("Seminar: Algebra and Logic");
            sall.setECTS("5");
            sall.setSemester("Frühling");
            sall.setLevel("Masterleistung im Bachelor");
            courseFacade.create(sall);
            
            Course scog = new Course();
            scog.setTitle("Seminar: Computer Graphics");
            scog.setDescription("The goal of the computer graphics seminar is to introduce students to current research in computer graphics. Topics vary each semester, and range from 3D rendering, modeling, and animation, to image processing and computational photography. The seminar includes lectures by the instructor and external guests to introduce selected topics. In addition, we will read and discuss recent research papers. The seminar also provides the opportunity for students pursuing Bachelors and Masters projects to present their work.");
            scog.setECTS("5");
            scog.setSemester("Frühling");
            scog.setLevel("Masterleistung im Bachelor");
            courseFacade.create(scog);
            
            Course ssoc = new Course();
            ssoc.setTitle("Seminar: Software Composition");
            ssoc.setDescription("Seminar: Software Composition");
            ssoc.setECTS("5");
            ssoc.setSemester("Frühling");
            ssoc.setLevel("Masterleistung im Bachelor");
            courseFacade.create(ssoc);
            */
        } catch (Exception e) {
            // TBD
        }
        // TODO More
    }

}
