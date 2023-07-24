import React from "react";
import "./summary.css";
export default function Summary() {
  return (
    <>
      <div className="summary-wrap" id="summary">
        <h1>FAQ'S</h1>
        <div className="summary-content">
          <details>
          <summary>Know About US!</summary>
            <p>We have over 50 years combined experience in the fruit and vegetable industry; we owned and operated a plantation in Carnarvon growing produce for 18 years, only leaving for our children to further their education.
              Over these years we built up good relationships with our fellow growers & salesmen, which we still maintain. Now that we have been running fruit n vegies r us for 20 years, we can provide our customers with high quality, WA grown produce which is much fresher & cheaper, due to our experience & inside knowledge as to where to source good produce all year round.
              Also, our produce goes direct to our customers, not having to pass through a distribution centre.
-             fresher is better!</p>
          </details>
          <details>
            <summary> seasonal boxes</summary>
            <p>Mixed seasonal boxes of fresh fruits and vegetables are the best value, locally sourced and supplied using our 50 years of experience in the industry to bring you the best possible standard and value. Tell us what you like and what you don't like for your seasonal fruit and vegetable boxes and we'll make sure you get what you need delivered right to your home or business. </p>
          </details>
          <details>
            <summary>How It Works</summary>
            <p>Ordering from orgofield is easy. We operate a simple process for our customers as illustrated below. We have tons of satisfied customers both private & commercial and pride ourselves on getting it right each and every-time.
              *Order your Fruit and Vegies Online or on the phone
              *Your order is picked and packed with care by us
              *Your order is delivered to your home, work or function
              *Pay for your order on delivery with cash or in advance it's up to you </p>
          </details>
        </div>
      </div>
    </>
  );
}
