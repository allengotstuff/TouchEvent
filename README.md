# TouchEvent

## This is a tutorial project to help you understand Android TouchEvent, whats including in the projects:
- An sample Android project that has a a **ViewGroup**, **View**, **Activity** with its relevant method been logged.
- Screen Shot of method logging to show touchevent sequence.

### What is a TouchEvent:
A touchEvent is a series of action that always including (only one ACTION_DOWN), and (0 - any ACTION_MOVE) and (only one ACTION_UP).

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

