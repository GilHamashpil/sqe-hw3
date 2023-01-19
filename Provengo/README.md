# Testing PrestaShop using Provengo
This directory contains the Provengo project for testing PrestaShop.

1. replace the name of the folder 'prestaShop' with the name of your software (use underscore/title case to avoid spaces)
2. Search and replace for the word 'prestaShop' in the entire project and replace it with the new folder name. 


## Running the tests
To run a single random test, run:
```shell 
provengo run prestaShop
```

See the [Provengo README](prestaShop/README.md) for more useful commands.

## API
See [Provengo README](prestaShop/README.md) for a short description of the API.
For a full documentation go to [https://docs.provengo.tech](https://docs.provengo.tech)

## How we tested:
1. We started by creating the [story files](prestaShop/spec/js/OrderPizza.story.js).
2. We then ran the following command to generate the test model:
```shell
provengo analyze -f PDF prestaShop   
```
3. We repeated steps 1-2 until we were satisfied with the generated model.
4. We added [Event definitions](prestaShop/spec/js/OrderPizza.EventDef.js)   to define how the stories actuate the website using Selenium.
5. We used the following command to run the tests:
```shell
provengo run --show-sessions --max-windows prestaShop
```
6. We repeated steps 4-5 until we were satisfied with the result.
7. We recorded a video of the running tests and added it to the report. Since more than one browser session was opened, we recorded the entire screen. The link for the video is [prestaShop-addItemForSale.wmv](prestaShop\prestaShop-addItemForSale.wmv) and [prestaShop-addItemToWishlist.wmv](prestaShop\prestaShop-addItemToWishlist.wmv).
8. We copied the generated graph of the model to a file named [prastaShop-addItemToSale.pdf](prestaShop\prastaShop-addItemToSale.pdf) and  [prestaShop-addItemToWishlist.pdf](prestaShop\prestaShop-addItemToWishlist.pdf)inside this directory (the link should work).

### Story files
The test stories are in [Tests.story.js](prestaShop/spec/js/OrderPizza.story.js). See the file for a detailed description of the stories.

### Events definition files
The specification for the events are given in [EventDef.js](prestaShop/spec/js/OrderPizza.EventDef.js). See the file for a detailed description of the events.

