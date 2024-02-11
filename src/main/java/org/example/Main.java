import java.util.Scanner;

class DistanceCalculator {
    // Объявляем константу в которой указан радиус земли в км
    private static final double EARTH_RADIUS = 6371.0;

    public static void main(String[] args) {
        // Чтение ввода в консоль
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите широту первой точки (в градусах):");
        double lat1 = scanner.nextDouble();

        System.out.println("Введите долготу первой точки (в градусах):");
        double lon1 = scanner.nextDouble();

        System.out.println("Введите широту второй точки (в градусах):");
        double lat2 = scanner.nextDouble();

        System.out.println("Введите долготу второй точки (в градусах):");
        double lon2 = scanner.nextDouble();

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Расстояние между двумя точками: " + distance + " км");

        scanner.close();
    }

    // Метод для вычисления расстояния между двумя точками
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Переводим градусы в радианы
        double lat1Radians = Math.toRadians(lat1);
        double lon1Radians = Math.toRadians(lon1);
        double lat2Radians = Math.toRadians(lat2);
        double lon2Radians = Math.toRadians(lon2);

        // Вычисляем разницу между широтами и долготами
        double dLat = lat2Radians - lat1Radians;
        double dLon = lon2Radians - lon1Radians;

        // Вычисляем расстояние между двумя точками с использованием формулы гаверсинусов
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1Radians) * Math.cos(lat2Radians) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        return distance;
    }
}
