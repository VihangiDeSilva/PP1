public class Skill {

        private String name;            // Declaration of skill Classure
        private String optional;
        private String shortDescription;
        private int statAffinity;
        private int ranks;
        private Skill next_Skill;

        public Skill(String name, String optional, String shortDescription, int statAffinity, int ranks, Skill next_Skill) {
            super();
            this.name = name;
            this.optional = optional;                       //Calling the objects from the constructor
            this.shortDescription = shortDescription;
            this.statAffinity = statAffinity;
            this.ranks = ranks;
            this.next_Skill = next_Skill;
        }



        public  String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOptional() {
            return optional;
        }

        public void setOptional(String optional) {
            this.optional = optional;
        }

        public String getShortDescription() {
            return shortDescription;
        }

        public void setShortDesc(String shortDescription) {
            this.shortDescription = shortDescription;
        }

        public int getStatAffinity() {
            return statAffinity;
        }

        public void setStatAffinity(int statAffinity) {
            this.statAffinity = statAffinity;
        }

        public int getRanks() {
            return ranks;
        }

        public void setRanks(int ranks) {
            this.ranks = ranks;
        }

        public Skill getNext_Skill() {
            return next_Skill;
        }

        public void setNext_Skill(Skill next_Skill) {
            this.next_Skill = next_Skill;
        }


    }



