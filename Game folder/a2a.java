import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class a2a {
    private static Map<String, Double> stockPrices = new HashMap<>();
    private static Map<String, Integer> portfolio = new HashMap<>();

    public static void main(String[] args) {
        stockPrices.put("AAPL", 150.50);
        stockPrices.put("GOOGL", 2500.30);
        stockPrices.put("TSLA", 700.0);
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Available stocks: AAPL, GOOGL, TSLA");
            System.out.print("Enter the stock symbol to buy/sell (or type 'quit' to exit): ");
            String stockSymbol = scanner.next();

            if (stockSymbol.equalsIgnoreCase("quit")) {
                break;
            }

            if (!stockPrices.containsKey(stockSymbol)) {
                System.out.println("Invalid stock symbol. Try again.");
                continue;
            }

            System.out.print("Enter the number of shares: ");
            int shares = scanner.nextInt();

            System.out.print("Enter 'buy' or 'sell': ");
            String action = scanner.next();

            if (action.equalsIgnoreCase("buy")) {
                buyStock(stockSymbol, shares);
            } else if (action.equalsIgnoreCase("sell")) {
                sellStock(stockSymbol, shares);
            } else {
                System.out.println("Invalid action. Try again.");
            }

            displayPortfolio();
        }

        System.out.println("Goodbye! Thank you for using the stock trading platform.");
        scanner.close();
    }

    private static void buyStock(String stockSymbol, int shares) {
        double stockPrice = stockPrices.get(stockSymbol);
        double cost = stockPrice * shares;

        if (portfolio.containsKey(stockSymbol)) {
            portfolio.put(stockSymbol, portfolio.get(stockSymbol) + shares);
        } else {
            portfolio.put(stockSymbol, shares);
        }

        System.out.println("Bought " + shares + " shares of " + stockSymbol + " at $" + stockPrice + " per share. Total cost: $" + cost);
    }

    private static void sellStock(String stockSymbol, int shares) {
        if (!portfolio.containsKey(stockSymbol) || portfolio.get(stockSymbol) < shares) {
            System.out.println("Not enough shares to sell. Try again.");
        } else {
            double stockPrice = stockPrices.get(stockSymbol);
            double earnings = stockPrice * shares;

            portfolio.put(stockSymbol, portfolio.get(stockSymbol) - shares);

            System.out.println("Sold " + shares + " shares of " + stockSymbol + " at $" + stockPrice + " per share. Total earnings: $" + earnings);
        }
    }

    private static void displayPortfolio() {
        System.out.println("Current Portfolio:");
        for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
            String stock = entry.getKey();
            int shares = entry.getValue();
            double stockPrice = stockPrices.get(stock);
            
            System.out.println(stock + " - Shares: " + shares + ", Current Price: $" + stockPrice + ", Total Value: $" + (shares * stockPrice));
        }
        System.out.println();
    }
}

