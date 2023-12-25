import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class StressTest {

    public static void main(String[] args) {
        String url = "https://vijaisuria.github.io"; // Replace with your URL

        int numberOfRequests = 10000;
        List<CompletableFuture<Void>> requestFutures = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();

        for (int i = 0; i < numberOfRequests; i++) {
            final int requestNum = i; // Final variable to use within lambda

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            CompletableFuture<Void> requestFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::statusCode)
                    .thenAccept(statusCode -> {
                        if (statusCode == 200) {
                            System.out.println("Request " + requestNum + " successful: " + statusCode);
                            // You can perform further actions here upon successful request
                        } else {
                            System.out.println("Request " + requestNum + " failed: " + statusCode);
                        }
                    })
                    .exceptionally(throwable -> {
                        System.out.println("Request " + requestNum + " failed: " + throwable.getMessage());
                        return null;
                    });

            requestFutures.add(requestFuture);
        }

        // Wait for all requests to complete
        CompletableFuture<Void> allRequests = CompletableFuture.allOf(
                requestFutures.toArray(new CompletableFuture[0])
        );

        try {
            allRequests.get(); // Wait for all requests to complete
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
