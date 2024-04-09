var ScalaMeter = (function(parent) {
  var my = { name: "data" };
  my.index = [{"scope" : ["sequentialScan", "SequentialScan", "scan"], "name" : "Test-2", "unit" : "", "file" : "..\/sequentialScan.SequentialScan.scan.Test-2.dsv"}];
  my.tsvData = ['date	param-size	value	success	cilo	cihi	units	complete\n2023-08-30T17:46:15Z	1000000	6.05972172222222	true	5.925	6.194	ms	"5.864459 6.076706 6.139234 6.165784 5.768364 5.94434 6.039354 6.156295 6.168121 6.17023 6.175716 6.176858 6.028291 6.04094 6.129122 6.198687 5.873805 5.945037 5.998196 6.030642 6.187845 6.192464 6.199481 6.220202 5.813061 5.94649 6.060194 6.137049 5.832752 5.897666 6.030157 6.098292 6.075202 6.085597 6.129327 6.154022"\n2023-08-30T17:46:15Z	2000000	12.082294305555555	true	11.835	12.330	ms	"11.678001 11.891565 12.060859 12.162657 11.748048 12.081634 12.09713 12.217315 12.309297 12.322214 12.327284 12.34341 12.118901 12.20226 12.248064 12.347417 11.799025 11.918848 12.087128 12.312153 12.184694 12.215238 12.312641 12.580443 11.748644 11.866521 12.09157 12.099759 11.698818 11.714403 11.931557 11.941043 11.732888 12.052185 12.245263 12.273718"\n2023-08-30T17:46:15Z	3000000	18.213984444444446	true	17.874	18.554	ms	"17.879875 18.065561 18.241527 18.390428 17.42247 17.815942 17.995305 18.576318 18.427328 18.463747 18.523426 18.602348 17.911642 18.196808 18.290906 18.584261 17.85964 18.380103 18.430944 18.56168 17.66611 17.890289 18.411778 18.421768 18.393053 18.460918 18.534112 18.579547 17.835316 18.008186 18.238628 18.284683 17.794054 17.814828 18.223604 18.526307"\n2023-08-30T17:46:15Z	4000000	34.47761825	true	17.075	51.880	ms	"23.549828 24.02044 24.632846 24.957629 23.391756 23.44745 23.538488 23.692212 60.148103 60.185148 60.247956 60.256972 23.493514 23.541019 23.668234 23.820628 23.930332 24.339911 24.547982 24.549223 23.943797 44.258122 59.674303 60.440629 58.360193 58.393729 58.859163 59.179489 23.995493 24.256254 24.314057 24.549708 24.039244 24.24993 24.290073 24.430402"\n2023-08-30T17:46:15Z	5000000	30.248782583333327	true	29.753	30.745	ms	"29.489238 30.649716 30.688315 30.81994 30.317162 30.393137 30.474524 30.539714 30.503214 30.688625 30.714513 30.776272 29.659912 29.9484 29.958285 30.45733 29.79595 30.669016 30.690564 30.950326 29.60069 29.927297 30.153431 30.178793 29.849698 30.009448 30.318874 30.319647 29.235133 29.870637 30.604252 30.62856 29.296789 29.685648 30.48392 30.609203"\n2023-08-30T17:46:15Z	6000000	36.386771694444434	true	35.933	36.841	ms	"36.376168 36.41901 36.592121 36.595783 35.858446 36.180461 36.303795 36.500769 36.338734 36.784492 36.790156 36.854232 35.438761 36.018544 36.525914 36.531447 35.75888 36.562544 36.800331 37.401716 36.345154 36.361192 36.615886 36.97815 36.111418 36.399994 36.50378 36.629645 35.455461 35.489411 36.447614 36.780853 36.05462 36.263903 36.313833 36.540563"\n2023-08-30T17:46:15Z	7000000	42.08968552777778	true	41.591	42.588	ms	"41.679968 41.925383 42.551516 42.564312 41.411816 41.500599 42.198817 42.28906 41.413849 41.633639 41.828576 42.110394 41.581605 41.930288 41.957911 42.176366 42.16896 42.560285 42.56466 42.617535 41.11325 41.926859 42.026686 42.07251 41.241208 41.607399 42.121787 42.177774 42.429959 42.575445 42.743123 43.132243 42.111122 42.245182 42.450942 42.587651"\n2023-08-30T17:46:15Z	8000000	48.18188258333335	true	47.505	48.858	ms	"47.359346 47.519548 47.981443 48.774611 47.470229 47.823771 47.850112 47.972331 47.405073 47.621849 48.241898 48.303569 48.003407 48.074093 48.361054 48.481983 48.434792 48.60895 49.482177 49.573699 47.819152 47.831575 47.921456 47.960815 47.113032 47.630818 48.213319 48.711459 47.496958 47.564646 49.050343 49.235817 47.905911 48.840564 48.950922 48.957051"\n2023-08-30T17:46:15Z	9000000	54.23537702777779	true	53.542	54.929	ms	"52.724011 54.256215 54.83126 55.074198 52.771434 54.437412 54.474651 55.232989 53.303463 53.419022 54.427729 54.814204 53.682733 53.809864 53.847948 53.888129 53.889382 54.421394 54.525819 54.6075 53.208981 53.956045 54.273848 54.518708 53.925801 54.984915 55.158551 55.199724 53.878514 54.113329 54.365933 54.979851 53.940967 54.217462 54.468661 54.842926"\n2023-08-30T17:46:15Z	10000000	60.58490644444443	true	59.683	61.487	ms	"59.126081 60.168889 60.53177 60.90274 58.927686 61.12276 61.345386 61.591261 58.053431 59.616117 60.100448 60.484544 60.917504 61.332484 61.479444 61.575578 59.653345 60.156992 60.36147 61.134353 59.857692 60.913859 61.212732 61.520845 59.547756 60.938605 61.013589 61.429484 60.262916 60.400939 60.70869 61.14157 60.066836 60.701434 61.25998 61.497422"\n'];
  parent[my.name] = my;
  return parent;
})(ScalaMeter || {});