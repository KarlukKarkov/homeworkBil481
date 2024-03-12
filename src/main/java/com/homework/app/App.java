package com.homework.app;
import java.util.*;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    //Methods aim is getting First count1 elements of x1 and first count2 elements of x2, later picking up a number randomly.
    public static Integer randomSelect(ArrayList<Integer> x1, ArrayList<Integer> x2, int count1, int count2){
    	ArrayList<Integer> all=new ArrayList<>();
    	
    	if(x1!=null) for(int i=0;i<count1;i++) if(x1.size()>i) all.add(x1.get(i));
    	if(x2!=null) for(int i=0;i<count2;i++) if(x2.size()>i) all.add(x2.get(i)); 
    	
    	if(all.size()==0) return null;
    	//all now contains all the possible numbers, now randomly select one
    	return all.get((int)(Math.random()*all.size()));
    	
    }
    
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);
	  
	  java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          System.out.println(inputList2);

          String input2 = req.queryParams("input2").replaceAll("\\s","");
          int input2AsInt = Integer.parseInt(input2);
	
	String input22 = req.queryParams("input22").replaceAll("\\s","");
          int input2AsInt2 = Integer.parseInt(input22);
          
          int result = App.randomSelect(inputList, inputList2,input2AsInt,input2AsInt2);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
	  return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
