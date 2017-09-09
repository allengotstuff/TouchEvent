# TouchEvent

## This is a tutorial project to help you understand Android TouchEvent, whats including in the projects:
- An sample Android project that has a a **ViewGroup**, **View**, **Activity** with its relevant method been logged.
- Screen Shot of method logging to show touchevent sequence.

### What is a TouchEvent:

There are three basic types of TouchEvent:
* ACTION_DOWN is when you are finger first touch the screen.
* ACTION_MOVE is while you are finger is on the screen, it also move postion in x,y axies
* ACTION_MOVE is when you are finger left the screen.

**A touchEvent is a series of action that always including (only one ACTION_DOWN), and (0 - any ACTION_MOVE) and (only one ACTION_UP).**

Just imagine when you quickly tap the screen, the second you firgure touchs screen, the ACTION_DOWN event is trigger, and depends on whether you move your firgure while still touch the screen, it will trigger 0 - any of ACTION_MOVE. Finally, when you move your fingure away from the screen, once your firgure aparts from screen, the ACTION_UP is triggered. That is a complete TouchEvent series. __Remember, When your firgure left the screen, which the ACTION_UP is triggered. This touchEvent series is finish, if you touch screen after that, a brand new TouchEvent series will be calculated.__

### Three different class that can accept touchEvent and its available method:
- Activity has **dispatchTouchEvent** and **onTouchEvent**

- ViewGroup has **dispatchTouchEvent**, **onInterceptTouchEvent** and **onTouchEvent**

- View has **dispatchTouchEvent** and **onTouchEvent**

#### dispatchTouchEvent:
In a sense, when a touchEvent is triggered, the __Activity__ alway first received the Event, and if rootView is not intereted in consuming this touchEvent, it passes event to its children __ViewGroup__, and if the ViewGroup is not intereted in consuming this touchEvent, it passes event to its children __View__. So _dispatchTouchEvent_ will be called in sequence from Activity -- ViewGroup -- View.

#### onTouchEvent:
As the event is pass from Activity to View, nobody is interested in consuming the event, no matter how many layer of View/ViewGroup you has, it will eventually go to the last view, which doesn't have any more children. In this case, the _onTouchEvent_ method will be trigger on the current view that are assiocated with the event, and if still this view is not interested in consuming the event, it will pass the event to its direct parent, and same thing will happend to the parent. Eventually, the event will be passed to the Activtiy's onTouchEvent.

#### onInterceptTouchEvent(only for ViewGroup):
When event pass to a _ViewGroup_ through _dispatchTouchEvent_ function, _onInterceptTouchEvent_ is a block of code inside the funtion that are being called. This way, it give ViewGoup a chance to intercept event and invert the event passing direction to the opposite. For example When _onInterceptTouchEvent_ is interested in intercept event, instead of passing event up to its children view through _dispatchTouchEvent_, it triggers _onTouchEvent_ on itself, and pass the event down to Activity _onTouchEvent_

#### How to Consume Event:
All the event handle function has to return a boolean, In a default case, 
* Activity: (dispatchTouchEvent-False), (onTouchEvent-True)
* ViewGroup:  (dispatchTouchEvent-False),(onInterceptTouchEvent-False), (onTouchEvent-false)
* View:  (dispatchTouchEvent-False), (onTouchEvent-false), in some cases, a button's onTouchEvent return's true.

By return True, you are telling the system, that this view in interested in consuming the Event, althougth there are a slide differentation between the three method:
* dispatchTouchEvent ==true :  The remaing events destination will go to this funtion at this view and stop passing. **If return true, mutiple view/viewgroup's dispatchTouchEvent can still been called, depends on other view/viewgroup's order in the tree,**

* onInterceptTouchEvent ==true: The remaing events will not stop pass up the event to its children view of this viewgroup, instead, it will trigger self _onTouchEvent_ and pass down to RootView or Activity

* onTouchEvent ==true: The remaining event will be passed down through _dispatchTouchEvent_ to this View, and once event's got there, is will immediately handler by _onTouchEvent_, so no other View/ViewGourp's _onTouchEvent_ will be triggered for remaining events. **If return true, only this view/viewgroup's onTouchEvent will be trigger for remaining event. Other view/viewgroup's onTouchEvent will not be trigger.

![](https://github.com/allengotstuff/TouchEvent/blob/master/app/asset/Screen%20Shot%202017-09-08%20at%209.34.17%20PM.png)

####  Complete TouchEvent Flow without interception or consumption:

Event Pass UP:
* Activty(dispatchTouchEvent) - ViewGroup(dispatchTouchEvent) - ViewGroup(onInterceptTouchEvent) - View(onInterceptTouchEvent)

Event Pass Down:
* View(onTouchEvent) - ViewGroup(onTouchEvent) - Activty(onTouchEvent)


