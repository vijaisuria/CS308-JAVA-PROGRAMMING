import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Stress {

    public static void main(String[] args) {
        String url = "https://google.com"; // Replace with your URL

        int numberOfThreads = 10;
        int requestsPerThread = 100;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.execute(() -> {
                HttpClient client = HttpClient.newHttpClient();

                for (int j = 0; j < requestsPerThread; j++) {
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(url))
                            .build();

                    try {
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                        int statusCode = response.statusCode();

                        if (statusCode == 200) {
                            System.out.println("Request successful: " + statusCode);
                            // You can perform further actions here upon successful request
                        } else {
                            System.out.println("Request failed: " + statusCode);
                        }
                    } catch (Exception e) {
                        System.out.println("Request failed: " + e.getMessage());
                    }
                }
            });
        }

        // Shut down the executor service after all tasks are complete
        executorService.shutdown();

        try {
            // Wait for all tasks to complete or until timeout (adjust as needed)
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                // Timeout occurred before all tasks finished
                System.out.println("Some tasks were not completed within the timeout.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
