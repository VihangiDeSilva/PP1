import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GetSkillsAndClasses {

    public Class getClassesFromFile(){
            Class firstClass = null;
            Class previousClass = null;

            for(String line: GetSkillsAndClasses.readFromFile("Classes.txt")){      //Reading the file
                String [] classAttributes = line.split("/");
                Class classObj = new Class(classAttributes[0], Integer.parseInt(classAttributes[1]), Integer.parseInt(classAttributes[2]));
                if(firstClass == null){
                    firstClass = classObj;
                } else {
                    previousClass.setNext_Class(classObj);
                }
                previousClass = classObj;
            }
            return firstClass;
        }

        public Skill getSkillsFromFile(){
            Skill firstSkill = null;
            Skill previousSkill = null;

            for(String skill: GetSkillsAndClasses.readFromFile("Skills.txt")){      //Reading the skill.txt file
                String [] skillAttributes = skill.split("/");
                Skill skillObj = new Skill(skillAttributes[0], skillAttributes[1], skillAttributes[2], Integer.parseInt(skillAttributes[3]),
                        Integer.parseInt(skillAttributes[4] ), null);
                if(firstSkill == null){
                    firstSkill = skillObj;
                } else {
                    previousSkill.setNext_Skill(skillObj);
                }
                previousSkill = skillObj;
            }
            return firstSkill;
        }

        private static void writeToFile(String data) throws IOException {
            Files.write(Paths.get("Skills.txt"), data.getBytes());
        }

        private static List<String> readFromFile(String fileName) {
            List<String> lines = null;
            try {
                lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            } catch (IOException e) {

                e.printStackTrace();
            }
            return lines;
        }

    }




