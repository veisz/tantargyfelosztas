package hu.tanfel.model;

import hu.tanfel.model.controller.CourseService;
import hu.tanfel.model.service.DataApi;
import hu.tanfel.model.service.DataParser;
import hu.tanfel.model.service.FileReader;

public class App {
    private final CourseService courseService;

    private App() {
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        courseService = new CourseService(dataApi.getData("beosztas.txt"));
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {

        System.out.println("2. feladat: ");
        System.out.println("A fájlban " + courseService.getCourseCount() + " bejegyzés van.");
    }

}
