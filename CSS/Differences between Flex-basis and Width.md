# Differences between Flex-basis and Width

- Consider `flex-direction`

  > - flex-basis doesn't always apply to width.
  > - flex-direction is row, flex-basis controls width.
  > - flex-direction is column, flex-basis controls height.

- `flex-basis` applies only to flex items. Flex containers will ignore flex-basis, but can use width and height

- `flex-basis` works only on the main axis.

- `flex-basis` has no effect on absolutely-positioned flex items.



### Flex Items Formula

- content -> width -> flex-basis (limted by max|min-width)
- If no `flex-basis` is specified, then the `flex-basis` falls back to the item's `width` property.
- If no `width` is specified, then the `flex-basis` falls back to the computed width of the item's contents.
- `flex-basis` is limited by both `max-width/max-height` and `min-width/min-height`



### So?

- `width` is just a fallback when `flex-basis` is missing, and `min-width` and `max-width` are just upper and lower limits for the final `flex-basis`

  > You probably noticed that in all of our illustrations we visualized the size of the flex items **before** they got put into the flex container. We did that because that's exactly what `flex-basis` is: **the size of flex items before they are placed into a flex container**. It's the *ideal* or *hypothetical* size of the items. But `flex-basis` is **not a guaranteed size**! As soon as the browser places the items into their flex container, things change. In some of our examples above you saw that the flex items fit perfectly into their flex container, because the total sum of all the items' final `flex-basis` was the exact width of our container (1000px). That's great when that happens, but often times the flex container won't have enough space, or will have extra space, after all its items' `flex-basis` values are added up.

  

> 참고: 
>
> https://stackoverflow.com/questions/34352140/what-are-the-differences-between-flex-basis-and-width
>
> https://mastery.games/post/the-difference-between-width-and-flex-basis/

