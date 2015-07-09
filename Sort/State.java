public class State {
  private Transition[] transition;
  public State() {
    transtion = new Transtion[2];
  }
  public Transtion[] getTransition(){
    return transtion;
  }
  public void setTransition(Transition[] transition){
    this.transition = transition;
  }
 }
