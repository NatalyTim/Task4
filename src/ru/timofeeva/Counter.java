package ru.timofeeva;

public class Counter {
  private int cnt;
  private int inCnt = 0;
  private int outCnt = 0;
  private String TimeTo = "";

    public Counter(int inCnt, int outCnt){
        this.inCnt = inCnt;
        this.outCnt = outCnt;
        cnt = 0;
    }

    public int getInCnt() {
        return inCnt;
    }
    public void setInCnt(int inCnt) {
        this.inCnt = inCnt;
    }

    public int getOutCnt() {
        return outCnt;
    }

    public void setOutCnt(int outCnt) {
        this.outCnt = outCnt;
    }

    public int getCnt() {
        return cnt;
    }
    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getTimeTo() {
        return TimeTo;
    }

    public void setTimeTo(String timeTo) {
        TimeTo = timeTo;
    }

    public   void addIn(){
        this.inCnt++;
    }

    public   void addOut(){
        this.outCnt++;
    }

    @Override
    public String toString() {
        return "Counter{" +
                " inCnt=" + inCnt +
                ", outCnt=" + outCnt +", cnt=" + cnt+
                '}';
    }
}
