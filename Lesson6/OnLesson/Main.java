package Lesson6.OnLesson;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Main {

    // Не работает
//    private static final Logger logger = Logger.getLogger(Lesson6.OnLesson.Main.class.getName());

    private static final Logger logger = Logger.getLogger("");

    public static void main(String[] args) {

        // Базовый уровень логирования - INFO
        logger.setLevel(Level.ALL);
        logger.getHandlers()[0].setLevel(Level.ALL);

        // Форматирует сообщения
        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                return logRecord.getLevel() + "\t" + logRecord.getMessage() + "\t" + logRecord.getMillis() + "\n";
            }
        });

        // Фильтрует сообщения
        logger.getHandlers()[0].setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord logRecord) {
                return logRecord.getMessage().startsWith("Java5");
            }
        });

        logger.log(Level.CONFIG, "Java1");
        logger.log(Level.INFO, "Java2");
        logger.log(Level.SEVERE, "Java3");
        logger.log(Level.ALL, "Java4");
        logger.log(Level.FINE, "Java5-1");
        logger.log(Level.FINER, "Java5-2");
        logger.log(Level.FINEST, "Java5-3");
        logger.log(Level.OFF, "Java6");
        logger.log(Level.WARNING, "Java7");

        // Запись в файл
        try {
            // Создаем новый handler
            Handler handler = new FileHandler("mylog.log", true);
            handler.setLevel(Level.ALL);
            handler.setFormatter(new SimpleFormatter());

            // Привязываем handler к logger-у
            logger.addHandler(handler);

            logger.log(Level.SEVERE, "Java5-asd");
            logger.log(Level.SEVERE, "test1");
            logger.log(Level.SEVERE, "test2");
            logger.log(Level.SEVERE, "test3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
