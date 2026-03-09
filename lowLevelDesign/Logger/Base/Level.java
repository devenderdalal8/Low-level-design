package Logger.Base;

public enum Level {
   Debug(1) , Info(2) , Warning(3) , Error(4);

   private final int level;
   Level(int level){
      this.level = level;
   }

   public int getLevel(){
      return this.level;
   }

}
