
# Find Cheap Phone and Stocks Price "Predictor"

This project comprises two modules: **Stocks Price "Predictor"** and **Find Cheap Phone**, written in Java using Selenium WebDriver and TestNG.

## Stocks Price Predictor

### Description

A program for "predicting" changes in stock prices. The project interacts with a stock website, predicts whether the price will change within a given time, and records the results in the file `StocksPrice.txt`. Also for the correct answer the program will receive a `candy` and for the wrong answer the `candy` will be taken away

### Usage

1. Install the necessary dependencies.
2. Run the test method `StocksFinder` from the `Stocks` class.
3. Prediction results are saved in the "StocksPrice.txt" file.

### Dependencies

- Selenium WebDriver
- TestNG
- Java

### Configuration

- Stock website URL is specified in the `ConfigurationProperties` configuration file.

### Results

Prediction results are recorded in the "StocksPrice.txt" file in the following format:<br>
`yyyy-MM-dd HH:mm:ss stock_price `<br>
`Total candies count: `


# Find Cheap Phone

### Description

A program to search for a cheap phone on eBay. The project interacts with the eBay website, searches for a phone based on a query, selects the "Buy Now" option, retrieves information about the item, and records the URL in the "eBayLinks.txt" file.

### Usage

1. Install the necessary dependencies.
2. Run the test method `findPrice` from the `FindCheapPhone` class.
3. Search results are saved in the `"Links.txt"` file.

### Dependencies

- Selenium WebDriver
- TestNG
- Java

### Configuration

- eBay website URL is specified in the `ConfigurationProperties` configuration file.

### Results

Search results are recorded in the `"Links.txt"` file in the following format:
`yyyy-MM-dd HH:mm:ss Ebay_URL `
<br>


# License

This project is distributed under the `MIT License`.

## Contact

- Author: Serafim Petrov
- Email: serafimspetrovs@gmail.com
- GitHub: https://github.com/SerafimsPetrovs
<br>
<br>
  ![avatar](https://avatars.githubusercontent.com/u/148495939?v=4)







