# Introduction

SDET or a Engineering Manager in Quality, we are pretty hands on when it comes to Quality.

In the assignment, we are looking to see your design and coding skills to see how well you can take care of Quality;
within the quality department.

In this exercise, we provide a single automation problem to solve, and the goal is to see if you can design a clean UI
automation solution around it. The only requirement is to `use Java` as the core programming language (`Since this is the language of choice that we have decided to go forward with. It also makes it possible for us to properly review the assignments since we are not experts in all the different programming languages that can be used to do automation.`).

You can use any automation tool/library of your choice - we like selenium but feel free to take your pick.

If you like, we also provide you a base test framework so that you can directly get started writing tests, rather than setting up framework. [This framework]

Note: Base (vanilla) framework is to help you get things faster - “if you want to”. However we realize, sometimes you may like to use your own tool set, in which case you are free to do so - with no marks deducted - so feel free to pickup whatever you like :).

> One request, don’t use any low code or licensed automation tools.

Wish you all the best and success in getting this assignment done!

## Assignment

Web Automation: [Amazon](https://www.amazon.in/)

## Checklist of what we expect from this assignment ?

- [ ] Completion of the assignment.
- [ ] Test should run and pass in Chrome browser.
- [ ] Platform independent. (It should run on Windows, Mac or linux)
- [ ] Better page layer management.
- [ ] Helper methods for page interactions like click, sendkeys.
- [ ] Readable and clean code.
- [ ] Clear instructions about the framework and how to execute in the readme file.
- [ ] Commits history to see how you have approached the problem.
- [ ] Following good design principles.

> Note: Some of these requirements are intentionally kept vague.
> We want to see "the best" that you normally can deliver than leading you towards one way or another.

## What can get you closer to the job ?

- [ ] Unit tests if applicable.
- [ ] Framework having the provision to run the test in local or selenium grid/selenoid.
- [ ] Dockerizing the framework itself. (Build a docker image for the automated tests)
- [ ] Good design patterns wherever applicable.
- [ ] Anything that can help you to impress us.

## Steps

1. Open <https://www.amazon.in/>.
    > Note: Clicking on above URL may redirect you to amazon.com. Change it to amazon.in
2. Click on the `hamburger menu` in the top left corner.

    ![hamburger-menu.png](hamburger-menu.png)
3. Scroll own and then Click on the `TV, Appliances and Electronics` link under `Shop by Department` section.

    ![tv-appliance-electronics.png](tv-appliance-electronics.png)
4. Then click on `Televisions` under `Tv, Audio & Cameras` sub section.

    ![televisions.png](televisions.png)
5. Scroll down and filter the results by Brand ‘Samsung’.

    ![samsung.png](samsung.png)
6. Sort the Samsung results with price High to Low.

    ![sort-price-high-to-low.png](sort-price-high-to-low.png)
7. Click on the second highest priced item (whatever that maybe at the time of automating).
8. Switch the Window
9. Assert that  “About this item” section is present and log this section text to console/report.

    ![about-this-item.png](about-this-item.png)

## End of instructions

[Click here to go back to readme file](../README.md)
