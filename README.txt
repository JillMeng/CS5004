# Model
For our Model, we created three interfaces, which are Model.IShape, Model.IMotion and Model.IStatus.

## Model.IShape, Model.AbstractIShape, Model.Shape, Model.ShapeType, Model.ModelImpl
Model.IShape mainly focuses on representing shapes. It is implemented by Model.AbstractIShape, which is an abstract superclass that hold all the common code and attributes for Model.Shape. We have Model.Shape class that extends the Model.AbstractIShape. We designed the Model.AbstractIShape since we originally thought we are going to have Rectangle and Oval classes. But then we realize that we can combine Rectangle and Oval into Model.Shape class. For Assignment 6, we don't have enough time to combine Model.AbstractIShape and Model.Shape into one class, but we will redesign this part to combine this two in the next assignment. We then have Model.ShapeType enum class that has RECTANGLE and OVAL. Model.ModelImpl is a class we created to hold our shapes in a list. The relationship between Model.ModelImpl and Model.Shape is Model.ModelImpl "has-a" Model.Shape. For next assignment, we will consider to add an IShapes interface for user convenience.

## Model.IMotion, Model.Motion, Model.MotionType
Interface Model.IMotion is mainly used to represent the motion with time tick, including start tick and end tick, and status of the animation, including start status and end status. Model.Motion implements all the methods from Model.IMotion. Model.MotionType is an enum class that stores all the motion type we defined, which includes ChangePosition, ChangeColor and ChangeScale.

## Model.IStatus, Model.Position, Model.Color, Model.Scale
Model.IStatus is the interface used to get current status of the animation since we think user might want to check status of all shapes at some point. Model.Position is used to get current position status of the shape, Model.Color is used to get current color status of the shape, and Model.Scale is used to get current scale status of the shape.

## Relationships between the above three parts
Since AbstracIShape and Model.Shape will have Model.Position, Model.Color and Model.Scale, so there are "has-a" relationships between Model.AbstractIShape and Model.Position, Model.Color, Model.Scale, and there are also "has-a" relationships between Model.Shape and Model.Position, Model.Color, Model.Scale. Since Model.Motion will get start status and end status, so Model.Motion "extends" iStatus.

## One thing to mention about our design
We only have Model.ModelImpl that hold a list of shape, instead of having two classes for both shape list and motion list, because we want to have motion list initialized in each shape so that motion is grouped by each shape. In this way, when we want to access motion of a shape, we don't need to go over the whole motion lists, instead we only need to go to the shape and find one of its actions.
