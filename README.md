play_slick_web
==============

Play-Slick-Web
Modified from sample program of Play Framework to support RTB DSP Proxy

1. Get the click landing URL from DSP banners by Play WebService MVC
2. Save the ip, URL, Http header... into MySQL by slick
3. Redirect to landing page by getting the ip from X-Forward-For
4. Get the POST data from tracked App as it's activated/converted by Play WebService MVC
5. Save the ip, URL, Http header, decoded data into MySQL by slick
6. Match both ips, if more than one, choose the last click
7. Save the conversion info.

