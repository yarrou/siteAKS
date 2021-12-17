package site.alexkononsol.siteAKS.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @GetMapping("/")
    public String testPage(@RequestParam(defaultValue = "eng")String lng , ModelMap model, HttpServletRequest request){
        logger.info("new connect from ip {} , and language is {}",request.getRemoteAddr(),lng);
        String greeting="",history="",retraining="",examples="",contacts="",buttonCV="";
        if(lng.equals("by")){
            greeting = "<h1 class=\"major\" ><font color=\"#000000\">Вітаю, <br />мяне завуць - <br />Аляксандр <br/>Канановіч</font></h1>";
            history = "<h2 class=\"major\">Прафесія і хобі. </h2><p>Працяглы час я працаваў у сферы абслугоўвання і рамонту на вядучым горна-здабывальным прадпрыемстве рэспублікі. Праграмаванне на java было заняткам для душы. Аднак пасля падзей лета 2020 і рэпрэсій у дачыненні да мяне, я зразумеў, што мне прыйдзецца змяніць прафесію.</p>";
            retraining = "<h2 class=\"major\">Перанавучанне.</h2><p> Па дапамогу я звярнуўся ў фонд \"ByHelp\".Па ментарскай праграме перанавучання я пад кіраўніцтвам праграміста з 12-гадовым стажам вывучаў наступныя тэхналогіі : <b>Spring framework</b>, <b>Git</b>, <b>SQL</b>, <b>HTML</b>, <b>CSS</b>, <b>JS</b>.</p>";
            examples = "<h2 class=\"major\">Прыклады прац.</h2><p>Адна з работ, у якой я ужыў усе веды, атрыманыя ў працэсе перападрыхтоўкі - гэта стварэнне сайта <a href=\"https://fitnesstoall.by\"><b>Fitnesstoall.by</b></a>. Гэты сайт напісаны на Java і разгорнуты на экзэмпляры AWS EC2. Зыходны код праекта можна паглядзець <a href=\"https://github.com/yarrou/siteToOK\"><b>тут</b></a>. </p>";
            contacts = "<h2 class=\"major\">Звязацца са мной </h2><p>Я буду рады адказаць на вашы пытанні і пачуць прапановы.</p>";
            buttonCV = "Спампаваць CV";
        }
        if(lng.equals("ru")){
            greeting = "<h1 class=\"major\" ><font color=\"#000000\">Приветствую, <br />меня зовут - <br />Александр<br/> Кононович</font></h1>";
            history = "<h2 class=\"major\">Профессия и хобби.</h2><p>Продолжительное время я работал в сфере обслуживания и ремонта на ведущем горно-добывающем предприятии республики. Программирование на java было занятием для души. Однако после событий лета 2020 и репрессий в отношении меня, я понял ,что мне придется сменить профессию. </p>";
            retraining = "<h2 class=\"major\">Переобучение.</h2><p>За помощью я обратился в фонд \"ByHelp\". По менторской программе переобучения я под руководством программиста с 12-летним стажем изучал следующие технологии : <b>Spring framework</b>, <b>Git</b>, <b>SQL</b>, <b>HTML</b>, <b>CSS</b>, <b>JS</b>.</p>";
            examples = "<h2 class=\"major\">Примеры работ.</h2><p>Одной из работ, в которой я применил все знания, полученные в процессе переподготовки является создание сайта <a href=\"https://fitnesstoall.by\"><b>Fitnesstoall.by</b></a>. Данный сайт написан на Java, развёрнут на AWS EC2 инстансе. На исходный код проекта можно посмотреть <a href=\"https://github.com/yarrou/siteToOK\"><b>здесь</b></a>. </p>";
            contacts = "<h2 class=\"major\">Связаться со мной</h2><p>Я буду рад ответить на ваши вопросы и услышать предложения.</p>";
            buttonCV = "скачать CV";
        }
        if(lng.equals("eng")){
            greeting = "<h1 class=\"major\" ><font color=\"#000000\">Hello, <br />my name is <br />Aliaksandr <br/>Kananovich</font></h1>";
            history = "<h2 class=\"major\">Profession and hobby.</h2><p> For a long time I worked in the field of maintenance and repair at the leading mining enterprise of the republic. Java programming was a hobby. However, after the events of the summer of 2020 and the repressions against me, I realized that I would have to change my profession. </p>";
            retraining = "<h2 class=\"major\">Retraining.</h2><p>I turned to the ByHelp Foundation for help. Under the mentor retraining program, I studied the following technologies under the guidance of a programmer with 12 years of experience: <b>Spring framework</b>, <b>Git</b>, <b>SQL</b>, <b>HTML</b>, <b>CSS</b>, <b>JS</b>.</p>";
            examples = "<h2 class=\"major\">Work examples.</h2><p>One of the works in which I applied all the knowledge gained in the retraining process is the creation of the <a href=\"https://fitnesstoall.by\"><b>Fitnesstoall.by</b></a> website. This site is written in Java and deployed on an AWS EC2 instance. The source code of the project can be viewed <a href=\"https://github.com/yarrou/siteToOK\"><b>here</b></a>. </p>";
            contacts = "<h2 class=\"major\">Contact me</h2><p> I will be glad to answer your questions and hear suggestions.</p>";
            buttonCV = "download CV";
        }
        model.addAttribute("greeting",greeting);
        model.addAttribute("history",history);
        model.addAttribute("retraining",retraining);
        model.addAttribute("examples",examples);
        model.addAttribute("contacts",contacts);
        model.addAttribute("buttonCV",buttonCV);
        model.addAttribute("language",lng);

        return "index";
    }
}
