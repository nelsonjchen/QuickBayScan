# QuickBayScan

![_f99ad76c-446a-4468-8600-9fac06efb472](https://github.com/nelsonjchen/op-replay-clipper/assets/5363/1ad6b4eb-fc44-406f-b8b6-f7e75475091d)

A _really_, and I mean **really**, dumb quick barcode scanner for eBay Android. You scan a UPC or barcode or ISBN or whatever, it looks it up on eBay with "Sold Listings" checked.

That's it. That's all it does.

## Why?

Don't believe the prices for sale without "Sold Listings" checked. The price of what was sold recently is the only thing that matters.

Wish there was a way to do that without this app without tapping a lot? Me too. But there isn't. So here we are.

## Architecture

It's just a single Activity. The activity calls out to [Google Code Scanner][codescan] to scan the barcode. It then launches an Intent to open the eBay app with the search results or if you don't have the eBay app installed, it opens the eBay website in a browser.

[codescan]: https://developers.google.com/ml-kit/vision/barcode-scanning/code-scanner

## Recipe

Bind it to a button or a gesture in the OS to launch the app. Scan a barcode. It'll open the eBay app or website with the search results. 
