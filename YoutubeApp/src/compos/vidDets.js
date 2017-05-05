import React from 'react';

const YTVidDetail = (props) => {
  const videoDetailInfo = props.ytVidDetail;
  if(!videoDetailInfo){
    return <div>LOADING...</div>;
  }

  const vidId = videoDetailInfo.id.videoId;
  const vidUrlEmbed = `https://www.youtube.com/embed/${vidId}`;

  return (
    <div className="video-detail col-md-8">
      <div className="embed-responsive embed-responsive-16by9" >
        <iframe className="embed-responsive-item" src={vidUrlEmbed} ></iframe>
      </div>
      <div className="details" >
        <div>{videoDetailInfo.snippet.title}</div>
        <div>{videoDetailInfo.snippet.description}</div>
      </div>
    </div>
  );
};

export default YTVidDetail;
