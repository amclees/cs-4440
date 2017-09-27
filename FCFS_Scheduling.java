import java.awt.*;

import javax.swing.*;

import java.util.concurrent.*;


class ProcessInformation

{

  String pname;

  int arriveTime;

  int burstTime;

  int finishTime;

  int waitingTime;

  int startTime;

  public ProcessInformation(String pname,

      int arriveTime, int burstTime)

  {

    this.pname = pname;

    this.burstTime = burstTime;

    this.finishTime = finishTime;

  }

  public void executeProcess()

  {

    finishTime = startTime + burstTime;

    waitingTime = startTime - arriveTime;

  }

  public void setStartTime(int startTime)

  {

    this.startTime = startTime;

  }

  public int getFinishTime()

  {

    return finishTime;

  }

  public int getWaitingTime()

  {

    return waitingTime;

  }

}


public class FCFS_Scheduling

{

  static int processNum = 3;

  static ProcessInformation [] processSet = new ProcessInformation[processNum];


  public static void main(String args[])

  {

    processSet[0] = new ProcessInformation("p1", 0, 24);

    processSet[1] = new ProcessInformation("p2", 0, 3);

    processSet[2] = new ProcessInformation("p3", 0, 3);



    int tmpStartTime = 0;

    for (int i = 0; i < processNum; i++)

    {

      processSet[i].setStartTime(tmpStartTime);

      processSet[i].executeProcess();

      tmpStartTime = processSet[i].getFinishTime();

    }


    int totalWaitingTime = 0;

    for (int j = 0; j < processNum; j++)

    {

      totalWaitingTime = totalWaitingTime + processSet[j].getWaitingTime();

    }


    printFormat('+', '-');

    printFormat('|', ' ');

    printFormat('+', '-');

    System.out.print("0");


    printFinishNumber();


    double avg = totalWaitingTime / 3.0;


    System.out.println("avg : " + avg);

  }


  static void printFormat(char x, char y)

  {

    for (int k = 0; k < processNum; k++)

    {

      System.out.print(x);

      for (int l = 1; l < processSet[k].burstTime; l++)

      {

        System.out.print(y);

      }

    }

    System.out.print(x);

    System.out.println();

  }


  static void printFinishNumber()

  {

    for (int k = 0; k < processNum; k++)

    {

      System.out.print(" ");

      for (int l = 3; l < processSet[k].burstTime; l++)

      {

        System.out.print(" ");

      }

      System.out.print(processSet[k].finishTime);

    }

    System.out.println();

  }




}
