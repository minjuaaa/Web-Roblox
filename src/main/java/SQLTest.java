

// public class SQLTest {
//
//    public static void main(String[] args) {
//
//        String gameName = "대회제목";
//
//        String[] strs =  loadfile(""); // {"title, 45555, O", "2, "};
//
//        String sql ="";
//
//        sql = String.format("insert into game (gameName) values ('%s')", gameName);
//        // select max(gameId) from game"
////        int gameId = 0;
//
//        for(String str: strs) {
//            String[] tokens = str.split(",");
//            //int num = Integer.parseInt(tokens[0]);
//            String title = tokens[0];
//            String quizImage = tokens[1];
//            String correct = tokens[2];
//
//            sql = String.format("insert into quiz (title, quizImage, correct) values ('%s', '%s', '%s')",
//                    title, quizImage, correct);
//
//
//            // select max(quidId) from quiz"
////            int gameId = 0;
////            int quizId = 0;
////
////            sql = String.format("insert into quizInfo (gameId, quizId) values ('%d', '%d')",
////                    gameId, quizId);
////
////        }
////
//
//
//
//
//
//
//        System.out.println("");
//    }
//}}
