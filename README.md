
A Scala program modified from sample program of Play Framework to be a RTB DSP tracking proxy for POC.

1. GET the landing URL from the clicks of DSP banners by WebService MVC
2. Save the ip, URL, Http header, ... into MySQL DB by slick
3. Redirect to the original landing page
4. Get the POST data from tracked App when it is converted/activated
5. Save the ip, URL, Http header, decoded data, ...  into MySQL DB by slick
6. Match the above two ips.
7. If more than two records matched, choose the last one
8. Save the matched ip and time



