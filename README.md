# QuickBayScan

A _really_, and I mean **really** dumb quick barcode scanner for eBay Android. You scan a UPC or barcode or ISBN or whatever, it looks it up on eBay with "Sold Listings" checked.

## Why?

Don't believe the prices for sale without "Sold Listings" checked. The price of what was sold recently is the only thing that matters.

Wish there was a way to do that without this app? Me too. But there isn't. So here we are.

## Architecture

It's just a single Activity. The activity calls out to [Google Code Scanner][codescan] to scan the barcode. It then launches an Intent to open the eBay app with the search results or if you don't have the eBay app installed, it opens the eBay website in a browser.

[codescan]: https://developers.google.com/ml-kit/vision/barcode-scanning/code-scanner