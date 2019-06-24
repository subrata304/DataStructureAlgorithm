package com.interview.Array;

import java.util.ArrayList;

public class StockBuySell {

	/* https://www.geeksforgeeks.org/stock-buy-sell/ */

	public static void main(String args[]) {
		StockBuySell stock = new StockBuySell();

		// stock prices on consecutive days
		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		// int price[] = { 6, 5, 4, 3, 2, 1};

		stock.maxProfit(price);

		stock.stockBuySell(price, price.length);
	}

	// First variation -> If we are allowed to buy and sell only once
	public static int maxProfit(int[] prices) {

		int min_price = Integer.MAX_VALUE;
		int maxProfit = 0;

		for (int i = 0; i < prices.length; i++) {
			if (min_price > prices[i]) {
				min_price = prices[i];
			} else if (prices[i] - min_price > maxProfit) {
				maxProfit = prices[i] - min_price;
			}
		}
		System.out.println("Maximum possible Profit is: " + maxProfit);
		return maxProfit;
	}

	// Second Variation --> we are allowed to buy and sell multiple times.
	public static void stockBuySell(int price[], int n) {
		// Prices must be given for at least two days
		if (n == 1)
			return;

		int count = 0;

		ArrayList<Stock> sol = new ArrayList<Stock>();

		// Traverse through given price array
		int i = 0;
		while (i < n - 1) {
			// Find Local Minimum. Note that the limit is (n-2) as we are
			// comparing present element to the next element.
			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;

			// If we reached the end, break as no further solution possible
			if (i == n - 1)
				break;

			Stock e = new Stock();
			e.buy = i++;
			// Store the index of minimum

			// Find Local Maximum. Note that the limit is (n-1) as we are
			// comparing to previous element
			while ((i < n) && (price[i] >= price[i - 1]))
				i++;

			// Store the index of maximum
			e.sell = i - 1;
			e.maxProfit = price[e.sell] - price[e.buy];
			sol.add(e);

			// Increment number of buy/sell
			count++;
		}

		if (count == 0)
			System.out.println("There is no day when buying the stock " + "will make profit");
		else
			for (int j = 0; j < count; j++)
				System.out.println("Buy on day: " + (sol.get(j).buy + 1) + "        " + "Sell on day : "
						+ (sol.get(j).sell + 1) + "     " + "Profit is: " + sol.get(j).maxProfit);

		return;
	}

	/*
	 * Third Variation --> Given the stock price of n days, the trader is allowed to
	 * make at most k transactions, where a new transaction can only start after the
	 * previous transaction is complete, find out the maximum profit that a share
	 * trader could have made.
	 */

	// https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/

}

class Stock {
	int buy, sell, maxProfit;
}
