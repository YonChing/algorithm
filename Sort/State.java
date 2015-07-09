public class State {
  private Transition[] transition;
  private static int id = 0;
  private boolean isVisited;
  public State() {
    isVisited = false;
    stateId = id++;
    transtion = new Transtion[2];
  }
  public Transtion[] getTransition(){
    return transtion;
  }
  public void setTransition(Transition[] transition){
    this.transition = transition;
  }
 }
