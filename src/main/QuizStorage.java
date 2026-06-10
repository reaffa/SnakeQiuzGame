package main;

import java.util.ArrayList;
import java.util.Random;

public class QuizStorage{
    private ArrayList<QuizQuestion> Questions;
    private Random Random;

    public QuizStorage(){
        Questions = new ArrayList<>();
        Random = new Random();
        fillQuestions();
    }

    void fillQuestions(){
        Questions.add(new QuizQuestion(
                "Jaká je hodnota \"x\"?",
                "int x = 152 % 7;\n\n// Nápověda: % - operace modulo - výsledkem je zbytek po dělení, např.: 7 % 3 = 1",
                "5",
                60
        ));

        Questions.add(new QuizQuestion(
                "Kdo je vrah?",
                "U domů Novákových došlo krátce po poledni k vraždě paní Novákové.\nPaní Nováková, která si den předem nachystala hrnec s vodou, neboť v ono pondělí\nbyla pozastavena dodávka vody od 8:00 do 18:00, z důvodu oprav silnic,\nzrovna pila poobědní kávu.\n\nDetektivové začali vyslýchat 3 podezřelé:\nManžel Martin:\"Já v tu dobu dospával noční směnu. Přece si nemyslíte, že bych vlastní manželku připravil o život.\"\nDcera Barbara: \"Já jsem se zrovna sprchovala\"\nSyn Adam: \"Já školou povinný, v pondělí jsem psal test z matiky.\n\nODPOVĚĎ NAPIŠTE JEDNOSLOVNĚ V 1. PÁDĚ JAKO KŘESTNÍ JMÉNO!",
                "Barbara",
                75
        ));

        Questions.add(new QuizQuestion(
                "Kdo je vrah?",
                "Pan Smith byl zavražděn v neděli odpoledne. \nManželka si četla, kuchař vařil, pošťák doručoval poštu a zahradník sekal trávu.\n\nODPOVĚĎ ZAPIŠTE JEDNOSLOVNĚ V 1. PÁDĚ BEZ HÁČKŮ A ČÁREK! ",
                "Postak",
                40
        ));

        Questions.add(new QuizQuestion(
                "Pravý, nebo padělek?",
                "Archeolog našel vzácnou zlatou minci, na níž je vyraženo datum \"46 př. Kr.\". \nJe mince skutečná?\n\nNAPIŠTE \"ANO\", JE-LI MINCE SKUTEČNÁ, NEBO \"NE\", PAKLIŽE JDE O PADĚLEK!",
                "NE",
                30
        ));

        Questions.add(new QuizQuestion(
                "Mluví pravdu, či ne?",
                "Podezřelý u výslechu tvrdí: \"Ráno v 6:00 jsem utíkal na západ\na slunce mě oslepovalo přímo do očí.\n\nNAPIŠTE \"ANO\", MLUVÍ-LI PRAVDU, \"NE\", POKUD LŽE!",
                "NE",
                40
        ));

        Questions.add(new QuizQuestion(
                "Chemická ruleta",
                "Dva nepřátelé si objednali stejnou colu s ledem.\nPrvní ji vypil rychle a přežil. Druhý ji pil pomalu a zemřel na otravu.\nV čem byl jed?\n\nODPOVĚĎ NAPIŠTE JEDNOSLOVNĚ V 1. PÁDĚ BEZ HÁČKŮ A ČÁREK!",
                "Led",
                45
        ));

        Questions.add(new QuizQuestion(
                "Tma v chatě",
                "Vejdeš do promrzlé tmavé chaty. Máš u sebe jen krabičku od zápalek s pouze 1 zápalkou.\nV chatě jsou kamna, petrolejová lampa a svíčka. Co zapálíš jako první?\n\nODPOVĚĎ NAPIŠTE JEDNOSLOVNĚ V 1. PÁDĚ BEZ HÁČKŮ A ČÁREK!",
                "Zapalka",
                60
        ));

        Questions.add(new QuizQuestion(
                "Rychlovarná konvice",
                "Konvicí protéká proud 4 A a je připojena do sítě s napětím 230 V. \nJaký je příkon konvice?\n\nODPOVĚĎ NAPIŠTE VE WATTECH, ALE POUZE JAKO ČÍSLO BEZ JEDNOTKY",
                "920",
                30
        ));

        Questions.add(new QuizQuestion(
                "Účinnost elektromotoru",
                "Elektromotor spotřeboval 100 J elektrické energie,\nale vykonal práci jen 80 J (zbytek se změnil na teplo).\nJaká je jeho účinnost?\n\nODPOVĚĎ NAPIŠTE JAKO CELÉ ČÍSLO V % BEZ ZNAKU PROCENTA (TEDY NAPŘ.:\"25\", JE-LI ÚČINNOST 0,25)",
                "80",
                45
        ));

        Questions.add(new QuizQuestion(
                "Taxi",
                "Nástupní sazba do taxi je 40 Kč. Každý ujetý kilometr stojí 20 Kč. \nZákazník zaplatil celkem 240 Kč. \nKolik kilometrů ujel?\n\nODPOVĚĎ NAPIŠTE JAKO CELÉ ČÍSLO BEZ JEDNOTKY",
                "10",
                60
        ));

        Questions.add(new QuizQuestion(
                "Míchání štávy",
                "Ředíš sirup s vodou v poměru 1 : 4 (1 díl sirupu, 4 díly vody).\nChceš připravit 1 litr nápoje. \nKolik ml sirupu potřebuješ?\n\nODPOVĚĎ NAPIŠTE JAKO CELÉ ČÍSLO BEZ JEDNOTKY V MILILITRECH",
                "200",
                40
        ));

        Questions.add(new QuizQuestion(
                "Objem válce",
                "Spočítejte objem válce o výšce 50 cm, jehož podstava má PRŮMĚR 16 cm.\n\nODPOVĚĎ ZAPIŠTE V CENTIMETRECH VE TVARU \"<CELÉ ČÍSLO>pi\", TEDY NAPŘ.:\"27pi\" (SAMOZŘEJMĚ BEZ UVOZOVEK)",
                "3200pi",
                60
        ));

        Questions.add(new QuizQuestion(
                "Lekníny",
                "Lekníny na jezeře každý den zdvojnásobí svou plochu. Celé jezero zarostou za 30 dní. \nKterý den bylo jezero zarostlé přesně z poloviny?\n\nODPOVĚĎ NAPIŠTE JAKO CELÉ ČÍSLO BEZ TEČKY (NEPIŠTE \"40.\", ALE \"40\")",
                "29",
                50
        ));

        Questions.add(new QuizQuestion(
                "Věk je jen číslo",
                "Matce a dceři je dohromady 50 let. Matka je o 20 let starší než dcera. \nZa kolik let bude matce dvojnásobek co dceři?\n\nODPOVĚĎ NAPIŠTE JAKO CELÉ ČÍSLO",
                "5",
                75
        ));

        Questions.add(new QuizQuestion(
                "Black friday praktiky",
                "Svetr stál před zdražením 1000 Kč. Nejprve ho zdražili o 20%.\nPoté snížili cenu o 20%.\nKolik stojí teď?\n\nODPOVĚĎ NAPIŠTE JAKO CELÉ ČÍSLO BEZ JEDNOTKY",
                "960",
                60
        ));

        Questions.add(new QuizQuestion(
                "Stereometrie",
                "Máte velkou bílou krychli složenou z 3x3x3 bílých malých kostiček (celkem 27).\nCelou velkou krychli zvenku nabarvíte na červeno.\nKolik malých kostiček nemá ani jednu stranu červenou?\n\nODPOVĚĎ NAPIŠTE JAKO CELÉ ČÍSLO",
                "1",
                35
        ));

        Questions.add(new QuizQuestion(
                "Podání rukou",
                "Na oslavě se sešlo 8 přátel. Každý si s každým jednou potřásl rukou.\nKolik podání rukou proběhlo celkem?\n\nODPOVĚĎ ZAPIŠTE JAKO CELÉ ČÍSLO",
                "28",
                70
        ));

        Questions.add(new QuizQuestion(
                "Parkoviště",
                "Na parkovišti se nachází parkovací místa označená čísly:\n\n\t\t 06 | 68 | 88 | ?? | 98\nJaké číslo leží pod autem?\n\nODPOVEĎ ZAPIŠTE JAKO CELÉ ČÍSLO" ,
                "87",
                50
        ));

        Questions.add(new QuizQuestion(
                "Řezání klády",
                "Kolikrát musíš říznout, abys rozdělil kládu na 7 částí? Předpokládejme řezy jen napříč\n\nODPOVĚĎ ZAPIŠTE JAKO CELÉ ČÍSLO",
                "6",
                25
        ));

        Questions.add(new QuizQuestion(
                "Analogové hodiny",
                "Kolik stupňů svírají ručičky ciferníku, je-li 19:00?\n\nODPOVĚĎ ZAPIŠTE JAKO CELÉ ČÍSLO BEZ JEDNOTKY",
                "150",
                30
        ));

        Questions.add(new QuizQuestion(
                "Jáma v zemi",
                "Kolik metrů krychlových hlíny je v díře o rozměrech 2x2x2 metrů?\n\nODPOVĚĎ ZAPIŠTE JAKO CELÉ ČÍSLO",
                "0",
                30
        ));

        Questions.add(new QuizQuestion(
                "Posloupnosti",
                "Jaké číslo následuje v řadě?\n\t\t0, 3, 8, 15, 24,...\n\nODPOVĚĎ ZAPIŠTE JAKO CELÉ ČÍSLO",
                "35",
                50
        ));

    }
    public QuizQuestion getRandomQuestion(){
        if (Questions.isEmpty()) return null;

        return Questions.get(Random.nextInt(Questions.size()));
    }
}
