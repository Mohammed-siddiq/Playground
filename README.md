# PLAYGROUND

## Steps to build the docker image

After cloning this repo run the following to build the docker image:

```docker build -t  play-ground-dev-build:1.0```

Run the docker image as:

```docker run -p 8080:8080 -t play-ground-dev-build:1.0```

## Sample Curls

###State metrics

    curl -X GET \
      'http://localhost:8080/playground/impact-metrics/state?state=AK

    {
        "success": true,
        "message": null,
        "country": "US",
        "state": "AK",
        "impactedMetrics": {
            "totalTestResults": 32418,
            "positiveCases": 388,
            "negativeCases": 32030,
            "death": 10
        }
    }
    
 -
  
    curl -X GET \
              'http://localhost:8080/playground/impact-metrics/state?state=IL'   
        
    {
        "success": true,
        "message": null,
        "country": "US",
        "state": "IL",
        "impactedMetrics": {
            "totalTestResults": 538602,
            "positiveCases": 90369,
            "negativeCases": 448233,
            "death": 4058
        }
    }
    
  -
  
    curl -X GET \
                'http://localhost:8080/playground/impact-metrics/state?state=ILCS'   
          
      {
          "success": false,
          "message": "INVALID STATE PROVIDED ",
          "country": "US",
          "state": "ILCS",
          "impactedMetrics": null
      }
      
   
   ## US Metrics
   
    curl -X GET \
     http://localhost:8080/playground/impact-metrics/us \
     
     
     {
         "success": true,
         "message": null,
         "country": "US",
         "state": null,
         "impactedMetrics": {
             "totalTestResults": 10720185,
             "positiveCases": 1433696,
             "negativeCases": 9286489,
             "death": 81729
         }
     }
     
   
   
   
      